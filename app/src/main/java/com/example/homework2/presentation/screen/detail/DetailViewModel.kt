package com.example.homework2.presentation.screen.detail

import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework2.domain.model.DetailModel
import com.example.homework2.domain.usecase.GetFilmUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@Immutable
data class DetailViewState(
    val detailModel: DetailModel? = null,
    val isLoading: Boolean = true,
)

sealed interface DetailEvent {
    data class Init(val id: String) : DetailEvent
    object OnClick : DetailEvent
}

class DetailViewModel(
    private val getFilmUseCase: GetFilmUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(DetailViewState())
    val state: StateFlow<DetailViewState>
        get() = _state.asStateFlow()

    private val _film = MutableStateFlow<DetailModel?>(null)
    val film: StateFlow<DetailModel?>
        get() = _film.asStateFlow()

    private val _error = MutableStateFlow<Throwable?>(null)
    val error: StateFlow<Throwable?>
        get() = _error.asStateFlow()

    fun event(mainEvent: DetailEvent) {
        Log.e("DetailViewModel1", "try to move")
        when (mainEvent) {
            is DetailEvent.OnClick -> Unit
            is DetailEvent.Init -> {
                viewModelScope.launch {
                    try {
                        Log.e("DetailViewModel", "try to get info")
                        val film = getFilmUseCase(mainEvent.id)
                        _state.emit(
                            _state.value.copy(
                                detailModel = film
                            )
                        )
                        Log.e("DetailViewModel2", "set all this thing")
                        Log.e("DetailViewModel3", _film?.value?.title!!)
                    } catch (error: Throwable) {
                        Log.e("DetailViewModel4", error.toString())
                        _error.emit(error)
                    }
                }
            }
        }
    }
}
