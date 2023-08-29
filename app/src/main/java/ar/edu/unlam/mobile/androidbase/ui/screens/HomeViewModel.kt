package ar.edu.unlam.mobile.androidbase.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.androidbase.domain.kitty.models.Kitty
import ar.edu.unlam.mobile.androidbase.domain.kitty.services.KittyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@Immutable
sealed interface KittyUIState {
    data class Success(val kitty: Kitty) : KittyUIState
    object Loading : KittyUIState
    data class Error(val message: String) : KittyUIState
}

data class HomeUIState(
    val kittyState: KittyUIState = KittyUIState.Loading,
)

@HiltViewModel
class HomeViewModel @Inject constructor(val service: KittyUseCase) : ViewModel() {
    // Mutable State Flow contiene un objeto de estado mutable. Simplifica la operación de actualización de
    // información y de manejo de estados de una aplicación: Cargando, Error, Éxito.
    // (https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)
    // _Kitty State es el estado del componente "Kitty" inicializado como "Cargando"
    private val _kittyState = MutableStateFlow(KittyUIState.Loading)

    // Ui State es el estado general del view model.
    private val _uiState = MutableStateFlow(
        HomeUIState(_kittyState.value),
    )

    // UI expone el estado anterior como un Flujo de Estado de solo lectura.
    // Esto impide que se pueda modificar el estado desde fuera del ViewModel.
    val uiState = _uiState.asStateFlow()

    var DEFAULT: String = "https://icons.iconarchive.com/icons/iconsmind/outline/512/Cat-icon.png"

    init {
        updateKittyUrl()
    }

    fun updateKittyUrl() {
        viewModelScope.launch {
            service.getKitty().collect {
                HomeUIState(KittyUIState.Success(it))
            }
        }
    }

    //    fun getImageRequest(context: Context): ImageRequest {
    //        val imageLoader: ImageLoader = initUntrustImageLoader(context)
    //        // updateKittyUrl()
    //        val request = ImageRequest.Builder(context)
    //            .data(kittyUrl.value)
    //            .crossfade(true)
    //            .build()
    //
    //        viewModelScope.launch {
    //            Log.i("MainViewModel", "Ejecutando  ImageRequest")
    //            imageLoader.execute(request)
    //        }
    //        return request
    //    }

    //    private fun initUntrustImageLoader(context: Context): ImageLoader {
    //        // Create a trust manager that does not validate certificate chains
    //        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
    //            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}
    //
    //            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}
    //
    //            override fun getAcceptedIssuers(): Array<X509Certificate> {
    //                return arrayOf()
    //            }
    //        })
    //
    //        // Install the all-trusting trust manager
    //        val sslContext = SSLContext.getInstance("SSL")
    //        sslContext.init(null, trustAllCerts, java.security.SecureRandom())
    //
    //        // Create an ssl socket factory with our all-trusting manager
    //        val sslSocketFactory = sslContext.socketFactory
    //
    //        val module = HttpClientModule()
    //
    //        /*return ImageLoader.Builder(context)
    //            .okHttpClient(client)
    //            .build()*/
    //        return module.imageLoader(context)
    //    }
}
