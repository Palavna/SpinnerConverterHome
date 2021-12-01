package com.example.yana.spinnerhome.data.di

import com.example.yana.spinnerhome.data.ui.FirstViewModel
import com.example.yana.spinnerhome.data.ui.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val saveModules by lazy {
    loadKoinModules(
        listOf(viewModelModuleInfo)
    )
}

val viewModelModuleInfo = module {
    viewModel { FirstViewModel() }
    viewModel { SecondViewModel() }

}