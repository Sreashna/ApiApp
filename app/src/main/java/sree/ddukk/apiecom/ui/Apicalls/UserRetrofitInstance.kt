package sree.ddukk.apiecom.ui.Apicalls

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserRetrofitInstance {  // Renamed from RetrofitInstance to UserRetrofitInstance
    private const val BASE_URL = "https://api.escuelajs.co/"

    val api: UserApiService by lazy {  // Use the renamed UserApiService
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiService::class.java)  // Create instance of UserApiService
    }
}
