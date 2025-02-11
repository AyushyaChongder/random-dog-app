package ac.project.dogimageapp

import ac.project.dogimageapp.ui.GenerateDogsScreen
import ac.project.dogimageapp.ui.HomeScreen
import ac.project.dogimageapp.ui.RecentDogsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ac.project.dogimageapp.ui.theme.DogImageAppTheme
import ac.project.dogimageapp.viewmodel.DogViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: DogViewModel = viewModel()
            var currentScreen by remember { mutableStateOf("home") }

            when (currentScreen) {
                "home" -> HomeScreen { currentScreen = it }
                "generate" -> GenerateDogsScreen(viewModel) { currentScreen = "home" } // Added back navigation
                "recent" -> RecentDogsScreen(viewModel) { currentScreen = "home" } // Added back navigation
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onNavigate = {})
}
