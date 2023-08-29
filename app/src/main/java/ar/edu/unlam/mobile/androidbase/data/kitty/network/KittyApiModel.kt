package ar.edu.unlam.mobile.androidbase.data.kitty.network

import ar.edu.unlam.mobile.androidbase.domain.kitty.models.Kitty

data class KittyApiModel(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
) {
    fun toKitty(): Kitty {
        return Kitty(
            id = id,
            url = url,
            width = width,
            height = height,
        )
    }
}
