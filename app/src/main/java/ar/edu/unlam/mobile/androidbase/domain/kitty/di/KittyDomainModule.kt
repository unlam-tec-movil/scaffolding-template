package ar.edu.unlam.mobile.androidbase.domain.kitty.di

import ar.edu.unlam.mobile.androidbase.domain.kitty.services.GetNewKitty
import ar.edu.unlam.mobile.androidbase.domain.kitty.services.KittyUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class KittyDomainModule {

    @Binds
    @Singleton
    abstract fun bindKittyUseCase(kittyUseCaseImpl: GetNewKitty): KittyUseCase
}
