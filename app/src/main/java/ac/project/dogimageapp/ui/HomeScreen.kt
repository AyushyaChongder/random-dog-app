package ac.project.dogimageapp.ui

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Screens
@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("Random Dog Generator!", fontSize = 24.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(96.dp))
        Button(onClick = { onNavigate("generate") }, colors = ButtonDefaults.buttonColors(containerColor = Color(66, 134, 244)), border = BorderStroke(1.dp, color = Color.Black)) {
            Text("Generate Dogs",fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onNavigate("recent") }, colors = ButtonDefaults.buttonColors(containerColor = Color(66, 134, 244)), border = BorderStroke(1.dp, color = Color.Black)) {
            Text("My Recently Generated Dogs",fontSize = 14.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onNavigate = {})
}