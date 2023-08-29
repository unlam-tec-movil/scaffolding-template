package ar.edu.unlam.mobile.androidbase.data.kitty.network

import retrofit2.http.GET

interface KittyApi {
    @GET("/v1/images/search?limit=3")
    suspend fun getKitties(): List<KittyApiModel>
}
