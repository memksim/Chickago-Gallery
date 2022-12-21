package com.memksim.chickagogallery.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OkHttpModule {

    @Provides
    fun provideInterceptor(): Interceptor =
        Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()

            var response = chain.proceed(request)

            //single repeat request if request code is 5xx
            if ((response.code / 100) == 5) {
                response.close()
                response = chain.proceed(request)
            }

            response
        }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    @Provides
    fun provideCookieJar(): CookieJar =
        object : CookieJar {
            private var cookies: List<Cookie>? = null

            override fun loadForRequest(url: HttpUrl): List<Cookie> {
                return cookies ?: emptyList()
            }

            override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                this.cookies = cookies
            }

        }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptor: Interceptor,
        loggingInterceptor: HttpLoggingInterceptor,
        cookieJar: CookieJar
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(loggingInterceptor)
            .cookieJar(cookieJar)
            .callTimeout(1, TimeUnit.MINUTES)
            .build()

}
