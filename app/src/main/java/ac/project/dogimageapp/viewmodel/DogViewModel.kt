package ac.project.dogimageapp.viewmodel

import ac.project.dogimageapp.data.RetrofitInstance
import android.app.Application
import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map


private val Context.dataStore by preferencesDataStore(name = "dog_images")

class DogViewModel(application: Application) : AndroidViewModel(application) {
    private val dataStore = application.applicationContext.dataStore
    private val DOG_IMAGES_KEY = stringSetPreferencesKey("dog_images")

    private val _dogCache = mutableStateListOf<String>()
    val dogs: List<String> get() = _dogCache

    init {
        loadImages()
    }

    fun fetchDogImage(onImageFetched: (String) -> Unit) {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getRandomDog()

            if (_dogCache.size >= 20) _dogCache.removeLast() // Maintain LRU behavior
            _dogCache.add(0, response.message) // Add latest image at the top

            saveImages() // Save updated list
            onImageFetched(response.message)
        }
    }


    fun clearDogs() {
        viewModelScope.launch {
            _dogCache.clear()
            dataStore.edit { it[DOG_IMAGES_KEY] = emptySet() }
        }
    }

    private fun loadImages() {
        viewModelScope.launch {
            dataStore.data.map { it[DOG_IMAGES_KEY] ?: emptySet() }.collect { savedImages ->
                _dogCache.clear()
                _dogCache.addAll(savedImages)
            }
        }
    }

    private fun saveImages() {
        viewModelScope.launch {
            dataStore.edit { it[DOG_IMAGES_KEY] = _dogCache.toSet() }
        }
    }
}