package ar.edu.unlam.mobile.androidbase.data.kitty.repository

import ar.edu.unlam.mobile.androidbase.domain.kitty.models.Kitty
import kotlinx.coroutines.flow.Flow

interface KittyRepository {
    fun getKitty(): Flow<Kitty>
}
