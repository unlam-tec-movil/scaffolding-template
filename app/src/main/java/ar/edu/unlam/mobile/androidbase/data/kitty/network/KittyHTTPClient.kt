package ar.edu.unlam.mobile.androidbase.data.kitty.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class KittyHTTPClient @Inject constructor(private val api: KittyApi) : KittyHTTP {
    override fun getRandomKitty(): Flow<KittyApiModel> {
        return flow {
            emit(api.getKitties()[0])
        }
    }
}
