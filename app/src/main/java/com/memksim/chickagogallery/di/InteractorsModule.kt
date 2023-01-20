package com.memksim.chickagogallery.di

import com.memksim.chickagogallery.domain.interactors.GetBookmarksInteractor
import com.memksim.chickagogallery.domain.interactors.LoadArtworksInteractor
import com.memksim.chickagogallery.domain.interactors.UpdateBookmarksTableInteractor
import com.memksim.chickagogallery.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [UseCasesModule::class])
@InstallIn(SingletonComponent::class)
class InteractorsModule {

    @Provides
    fun provideLoadArtworksInteractor(
        getArtworksUseCase: GetArtworksUseCase,
        getBookmarksByArtworkTypeUseCase: GetBookmarksByArtworkTypeUseCase
    ): LoadArtworksInteractor = LoadArtworksInteractor(
        getArtworksUseCase = getArtworksUseCase,
        getBookmarksByArtworkTypeUseCase = getBookmarksByArtworkTypeUseCase
    )

    @Provides
    fun provideUpdateBookmarksTableInteractor(
        addToBookmarksUseCase: AddToBookmarksUseCase,
        addToRemoteBookmarksUseCase: AddToRemoteBookmarksUseCase,
        removeBookmarksUseCase: RemoveBookmarksUseCase,
        removeRemoteBookmarksUseCase: AddToRemoteBookmarksUseCase
    ): UpdateBookmarksTableInteractor = UpdateBookmarksTableInteractor(
        addToBookmarksUseCase = addToBookmarksUseCase,
        addToRemoteBookmarksUseCase = addToRemoteBookmarksUseCase,
        removeBookmarksUseCase = removeBookmarksUseCase,
        removeRemoteBookmarksUseCase = removeRemoteBookmarksUseCase
    )

    @Provides
    fun provideGetBookmarksInteractor(
        getBookmarksUseCase: GetBookmarksUseCase,
        getRemoteBookmarksUseCase: GetRemoteBookmarksUseCase
    ): GetBookmarksInteractor = GetBookmarksInteractor(
        getBookmarksUseCase = getBookmarksUseCase,
        getRemoteBookmarksUseCase = getRemoteBookmarksUseCase
    )

}