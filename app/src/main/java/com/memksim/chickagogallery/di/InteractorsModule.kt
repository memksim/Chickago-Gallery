package com.memksim.chickagogallery.di

import com.memksim.chickagogallery.domain.interactors.LoadArtworksInteractor
import com.memksim.chickagogallery.domain.interactors.UpdateBookmarksTableInteractor
import com.memksim.chickagogallery.domain.use_cases.AddToBookmarksUseCase
import com.memksim.chickagogallery.domain.use_cases.GetArtworksUseCase
import com.memksim.chickagogallery.domain.use_cases.GetBookmarksByArtworkTypeUseCase
import com.memksim.chickagogallery.domain.use_cases.RemoveBookmarksUseCase
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
        removeBookmarksUseCase: RemoveBookmarksUseCase
    ): UpdateBookmarksTableInteractor = UpdateBookmarksTableInteractor(
        addToBookmarksUseCase = addToBookmarksUseCase,
        removeBookmarksUseCase = removeBookmarksUseCase
    )

}