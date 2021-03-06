package com.example.yana.spinnerhome.di

import com.example.yana.spinnerhome.data.remote.CurrenciesInteractor
import com.example.yana.spinnerhome.data.remote.CurrenciesInteractorImpl
import com.example.yana.spinnerhome.data.remote.CurrenciesRetrofit
import com.example.yana.spinnerhome.ui.currencies.CurrenciesFragment
import com.example.yana.spinnerhome.ui.currencies.CurrenciesViewModel
import com.example.yana.spinnerhome.ui.firstFragment.FirstViewModel
import com.example.yana.spinnerhome.ui.secondFragment.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val saveModules by lazy {
    loadKoinModules(
        listOf(viewModelModuleInfo, networkModule, interactorModule)
    )
}

val networkModule = module {
    single {
        CurrenciesRetrofit.buildRetrofit()
    }
}

val interactorModule = module {
    single<CurrenciesInteractor> { CurrenciesInteractorImpl(get()) }
}

val viewModelModuleInfo = module {
    viewModel { FirstViewModel() }
    viewModel { SecondViewModel() }
    viewModel { CurrenciesViewModel(get()) }

}