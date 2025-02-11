package ac.project.dogimageapp.ui

import ac.project.dogimageapp.viewmodel.DogViewModel
import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecentDogsScreen(viewModel: DogViewModel,onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        LazyRow(modifier = Modifier.fillMaxWidth().height(350.dp).padding(4.dp)) {
            items(viewModel.dogs) { dogUrl ->
                Image(painter = rememberAsyncImagePainter(dogUrl), contentDescription = "Dog Image", modifier = Modifier.size(250.dp).padding(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.clearDogs() }, colors = ButtonDefaults.buttonColors(containerColor = Color(66, 134, 244)), modifier = Modifier.padding(16.dp)) {
            Text("Clear Dogs")
        }
        Button(onClick = onBack, colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Text("Back to Home", color = Color(66, 134, 244))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecentDogScreenPreview() {
    val fakeViewModel = DogViewModel(Application()) // Creates a dummy ViewModel for preview
    RecentDogsScreen(viewModel = fakeViewModel) { }
}