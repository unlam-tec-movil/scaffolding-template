package ar.edu.unlam.mobile.androidbase.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.androidbase.domain.kitty.models.Kitty
import ar.edu.unlam.mobile.androidbase.ui.components.KittyCard

@Composable
fun Home(modifier: Modifier = Modifier, viewModel: HomeViewModel = hiltViewModel()) {
    // La información que obtenemos desde el view model la consumimos a través de un estado de "tres vías".
    // Loading, Success y Error. Esto nos permite mostrar un estado de carga, un estado de éxito y un mensaje de error.
    val uiState: HomeUIState by viewModel.uiState.collectAsState()
    when (val kittyState = uiState.kittyState) {
        is KittyUIState.Loading -> {
            CircularProgressIndicator()
        }

        is KittyUIState.Success -> {
            Body(kitty = kittyState.kitty)
        }

        is KittyUIState.Error -> {
            // Error
        }

        else -> {}
    }
    Column() {
        //        Row() {
        //            Button(
        //                onClick = {
        //                    viewModel.updateKittyUrl()
        //                },
        //            ) {
        //                Text(text = "Actualizar imagen")
        //            }
        //        }
        //        Row() {
        //            Text(text = "Imagen de los gatitos")
        //        }
        //        Row() {
        //            SubcomposeAsyncImage(
        //                model = viewModel.getImageRequest(LocalContext.current),
        //                // placeholder = painterResource(R.drawable.placeholder),
        //                contentDescription = stringResource(R.string.cat_image),
        //                contentScale = ContentScale.FillBounds,
        //                loading = {
        //                    CircularProgressIndicator(
        //                        modifier = Modifier
        //                            .height(50.dp)
        //                            .width(50.dp),
        //                    )
        //                },
        //                modifier = Modifier
        //                    .height(300.dp)
        //                    .width(500.dp),
        //                // error = rememberAsyncImagePainter(model = mainViewModel.DEFAULT),
        //                onError = { error ->
        //                    run {
        //                        viewModel.updateKittyUrl()
        //                        Log.e("AsyncImageError", error.result.throwable.message.toString())
        //                    }
        //                },
        //                onLoading = { state ->
        //                },
        //
        //            )
        //        }
        //        Log.i("MainActivity", "third row")
        //        Row() {
        //            Text(text = "Pie de imagen")
        //        }
        //    }
    }
}

@Composable
fun Body(kitty: Kitty) {
    KittyCard(kitty = kitty)
}
