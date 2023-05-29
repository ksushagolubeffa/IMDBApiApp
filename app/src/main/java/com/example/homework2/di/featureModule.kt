package com.example.homework2.di

import com.example.homework2.presentation.screen.detail.detailModule
import com.example.homework2.presentation.screen.list.listModule
import org.koin.dsl.module

val featureModule = module {
    includes(
        detailModule,
        listModule
    )
}
