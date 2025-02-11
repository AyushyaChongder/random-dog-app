package ac.project.dogimageapp.ui

import ac.project.dogimageapp.viewmodel.DogViewModel
import android.app.Application
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@RequiresApi(35)
@Composable
fun GenerateDogsScreen(viewModel: DogViewModel, onBack: () -> Unit) {
    var imageUrl by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        imageUrl?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = "Dog Image",
                modifier = Modifier.size(250.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                isLoading = true
                viewModel.fetchDogImage { newImageUrl ->
                    imageUrl = newImageUrl
                    isLoading = false
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(66, 134, 244))
        ) {
            Text(if (isLoading) "Loading..." else "Generate!")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBack, colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Text("Back to Home", color = Color(66, 134, 244))
        }
    }
}

@RequiresApi(35)
@Preview(showBackground = true)
@Composable
fun GenerateScreenPreview() {
    val fakeViewModel = DogViewModel(Application()) // Creates a dummy ViewModel for preview
    GenerateDogsScreen(viewModel = fakeViewModel) { }
}
