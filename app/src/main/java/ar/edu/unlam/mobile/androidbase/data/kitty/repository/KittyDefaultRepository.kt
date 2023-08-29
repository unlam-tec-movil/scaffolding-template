package ar.edu.unlam.mobile.androidbase.data.kitty.repository

import ar.edu.unlam.mobile.androidbase.data.kitty.network.KittyHTTP
import ar.edu.unlam.mobile.androidbase.domain.kitty.models.Kitty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class KittyDefaultRepository @Inject constructor(
    private val kittyHTTP: KittyHTTP,
) : KittyRepository {
    override fun getKitty(): Flow<Kitty> {
        return flow {
            kittyHTTP.getRandomKitty().collect {
                emit(it.toKitty())
            }
        }
    }
}
