package sree.ddukk.apiecom.ui.Apicalls

import retrofit2.http.GET
import sree.ddukk.apiecom.ui.Models.modelItem

interface ApiService {
    @GET("products")
    suspend fun getAllProducts(): List<modelItem>
}
