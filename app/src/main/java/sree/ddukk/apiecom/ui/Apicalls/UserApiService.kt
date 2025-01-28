package sree.ddukk.apiecom.ui.Apicalls

import retrofit2.http.GET
import sree.ddukk.apiecom.ui.Models.User

interface UserApiService {
    @GET("api/v1/users")
    fun getUsers(): List<User>
}
