package com.memksim.chickagogallery.di

import com.memksim.chickagogallery.data.remote.client.ArtworksApi
import com.memksim.chickagogallery.data.repository.RemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module(includes = [RetrofitModule::class])
@InstallIn(SingletonComponent::class)
class RemoteModule{
    @Provides
    fun provideRemoteRepository(
        api: ArtworksApi
    ): RemoteRepository = RemoteRepository(api)
}





