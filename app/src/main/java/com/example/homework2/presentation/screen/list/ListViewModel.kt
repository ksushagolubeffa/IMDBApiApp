package com.example.homework2.presentation.screen.list

import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework2.domain.model.FilmList
import com.example.homework2.domain.usecase.GetFilmListUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@Immutable
data class ListViewState(
    val filmListModel: Flow<List<FilmList>> = MutableStateFlow(emptyList()),
)

sealed interface ListAction {
    data class Navigate(val id: String) : ListAction
}

sealed interface ListEvent {
    data class onItemClick(val detailModel: FilmList) : ListEvent
}

class ListViewModel(
    private val getFilmListUseCase: GetFilmListUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ListViewState())
    val state: StateFlow<ListViewState>
        get() = _state.asStateFlow()

    private val _action = MutableSharedFlow<ListAction?>()
    val action: SharedFlow<ListAction?>
        get() = _action.asSharedFlow()

    private var _filmList = MutableStateFlow<Flow<List<FilmList>>?>(null)
    val filmList: Flow<List<FilmList>>?
        get() = _filmList.value

    fun event(listEvent: ListEvent) {
        when (listEvent) {
            is ListEvent.onItemClick -> onListItemClick(listEvent.detailModel)
        }
    }

    init {
        viewModelScope.launch {
            try {
                val filmList = getFilmListUseCase()
                _filmList.value = filmList
                _state.emit(
                    _state.value.copy(
                        filmListModel = filmList
                    )
                )
            } catch (error: Throwable) {
                Log.e("ListViewModel", error.toString())
                _error.emit(error)
            }
        }
    }

    private val _error = MutableStateFlow<Throwable?>(null)
    val error: StateFlow<Throwable?>
        get() = _error.asStateFlow()


    private fun onListItemClick(detailModel: FilmList) {
        viewModelScope.launch {
            _action.emit(ListAction.Navigate(detailModel.id))
        }
    }
}
