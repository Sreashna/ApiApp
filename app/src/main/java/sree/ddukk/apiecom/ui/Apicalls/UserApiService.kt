package sree.ddukk.apiecom.ui.Apicalls

import retrofit2.http.GET
import sree.ddukk.apiecom.ui.Models.User

interface UserApiService {
    @GET("api/v1/users")
    suspend fun getUsers(): List<User> // Make this a suspend function
}
