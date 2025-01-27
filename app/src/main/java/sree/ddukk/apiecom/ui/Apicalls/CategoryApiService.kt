package sree.ddukk.apiecom.ui.Apicalls

import retrofit2.Call
import retrofit2.http.GET
import sree.ddukk.apiecom.ui.Models.Category

interface CategoryApiService {
    @GET("categories")
    fun getCategories(): Call<List<Category>>
}