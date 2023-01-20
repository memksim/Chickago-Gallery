package com.memksim.chickagogallery.di

import com.memksim.chickagogallery.data.repository.FirestoreRepository
import com.memksim.chickagogallery.data.repository.LocalRepository
import com.memksim.chickagogallery.data.repository.RemoteRepository
import com.memksim.chickagogallery.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [RemoteModule::class, LocalModule::class])
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun provideGetArtworksTypesUseCase(repository: RemoteRepository): GetArtworksTypesUseCase =
        GetArtworksTypesUseCase(repository = repository)

    @Provides
    fun provideGetArtworksUseCase(repository: RemoteRepository): GetArtworksUseCase =
        GetArtworksUseCase(repository = repository)

    @Provides
    fun provideGetBookmarksUseCase(repository: LocalRepository): GetBookmarksUseCase =
        GetBookmarksUseCase(repository = repository)

    @Provides
    fun provideAddToBookmarksUseCase(repository: LocalRepository): AddToBookmarksUseCase =
        AddToBookmarksUseCase(repository = repository)

    @Provides
    fun provideRemoveBookmarkUseCase(repository: LocalRepository): RemoveBookmarksUseCase =
        RemoveBookmarksUseCase(repository = repository)

    @Provides
    fun provideGetBookmarksByArtworkTypeUseCase(repository: LocalRepository): GetBookmarksByArtworkTypeUseCase =
        GetBookmarksByArtworkTypeUseCase(repository = repository)

    @Provides
    fun provideAddToRemoteBookmarksUseCase(repository: FirestoreRepository): AddToRemoteBookmarksUseCase =
        AddToRemoteBookmarksUseCase(repository = repository)

    @Provides
    fun provideGetRemoteBookmarksUseCase(repository: FirestoreRepository): GetRemoteBookmarksUseCase =
        GetRemoteBookmarksUseCase(repository = repository)
}