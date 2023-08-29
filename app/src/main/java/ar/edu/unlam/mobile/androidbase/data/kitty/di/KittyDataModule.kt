package ar.edu.unlam.mobile.androidbase.data.kitty.di

import ar.edu.unlam.mobile.androidbase.data.kitty.repository.KittyDefaultRepository
import ar.edu.unlam.mobile.androidbase.data.kitty.repository.KittyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class KittyDataModule {
    @Binds
    abstract fun bindKittyRepository(kittyRepositoryImpl: KittyDefaultRepository): KittyRepository

    @Binds
    abstract fun bindKittyHTTP(kittyHTTPImpl: KittyDefaultRepository): KittyRepository
}
