package com.example.yana.spinnerhome.di

import com.example.yana.spinnerhome.data.remote.CurrenciesRetrofit
import com.example.yana.spinnerhome.ui.firstFragment.FirstViewModel
import com.example.yana.spinnerhome.ui.secondFragment.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val saveModules by lazy {
    loadKoinModules(
        listOf(viewModelModuleInfo, networkModule)
    )
}

val networkModule = module {
    single {
        CurrenciesRetrofit.buildRetrofit()
    }
}

val viewModelModuleInfo = module {
    viewModel { FirstViewModel() }
    viewModel { SecondViewModel() }

}