package com.example.application_test.inject

import androidx.viewbinding.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    companion object {

        @Provides
        @ForDebugMode
        fun provideDebugMode(): Boolean = BuildConfig.DEBUG
    }
}