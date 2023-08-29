package ar.edu.unlam.mobile.androidbase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile.androidbase.ui.screens.Home
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    /*override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
}

@Composable()
fun MainScreen() {
    // Resource: https://developer.android.com/jetpack/compose/navigation#nav-to-composable
    // rememberNavController Crea el Navigator Controller.
    // Nav Controller es la API (interfaz) que nos permite navegar entre pantallas en Compose.
    // Dicho controller se envía por parámetro a los componentes que se usarán como destinos
    // de navegación. En nuestro ejemplo, son las pantallas. Para más info ver paradigma
    // componente contenedor.
    val controller = rememberNavController()
    Scaffold { paddingValue ->
        // NavHost es el componente que funciona como contenedor de los otros componentes que
        // podrán ser destinos de navegación.
        NavHost(navController = controller, startDestination = "home") {
            // composable es el componente que se usa para definir un destino de navegación.
            // Por parámetro recibe la ruta que se utilizará para navegar a dicho destino.
            composable("home") {
                // Home es el componente en sí que es el destino de navegación.
                Home(modifier = Modifier.padding(paddingValue))
            }
        }
    }
}
