package ac.project.dogimageapp.data

import retrofit2.http.GET

// API Service
interface DogApiService {
    @GET("breeds/image/random")
    suspend fun getRandomDog(): DogResponse
}

data class DogResponse(val message: String)