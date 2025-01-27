package sree.ddukk.apiecom.ui.ProductScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sree.ddukk.apiecom.ui.Apicalls.UserRetrofitInstance  // Use the new UserRetrofitInstance
import sree.ddukk.apiecom.ui.Models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = UserRetrofitInstance.api.getUsers()  // Use UserRetrofitInstance here
                _users.value = response
            } catch (e: Exception) {
                // Handle error here
            } finally {
                _isLoading.value = false
            }
        }
    }
}
