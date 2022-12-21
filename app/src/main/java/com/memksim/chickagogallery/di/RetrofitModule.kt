package com.memksim.chickagogallery.di

import com.memksim.chickagogallery.data.remote.client.ArtworksApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [OkHttpModule::class])
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun getBaseUrl(): String = "https://api.artic.edu/api/v1/"

    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
        client: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ArtworksApi = retrofit.create(ArtworksApi::class.java)

}

