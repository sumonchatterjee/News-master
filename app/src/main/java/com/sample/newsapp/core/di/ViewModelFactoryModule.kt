package com.sample.newsapp.core.di

import androidx.lifecycle.ViewModelProvider
import com.sample.newsapp.core.di.base.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}