package ar.edu.unlam.mobile.androidbase.domain.kitty.services

import ar.edu.unlam.mobile.androidbase.domain.kitty.models.Kitty
import kotlinx.coroutines.flow.Flow

interface KittyUseCase {
    fun getKitty(): Flow<Kitty>
}
