package ar.edu.unlam.mobile.androidbase.data.kitty.network

import kotlinx.coroutines.flow.Flow

interface KittyHTTP {
    fun getRandomKitty(): Flow<KittyApiModel>
}
