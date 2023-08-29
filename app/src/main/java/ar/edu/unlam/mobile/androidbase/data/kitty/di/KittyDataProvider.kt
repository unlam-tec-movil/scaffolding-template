package ar.edu.unlam.mobile.androidbase.data.kitty.di

import ar.edu.unlam.mobile.androidbase.data.kitty.network.KittyApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KittyDataProvider {
    @Provides
    @Singleton
    fun provideKittyAPI(gson: Gson): KittyApi {
        return Retrofit.Builder().baseUrl("https://api.thecatapi.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(KittyApi::class.java)
    }
}
