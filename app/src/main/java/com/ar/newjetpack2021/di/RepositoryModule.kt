package com.ar.newjetpack2021.di

import com.ar.newjetpack2021.network.RetrofitService
import com.ar.newjetpack2021.repository.NetworkRepository
import com.ar.newjetpack2021.repository.NetworkRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNetworkRepository(retroService: RetrofitService): NetworkRepository {
        return NetworkRepository_Impl(retroService)
    }

}