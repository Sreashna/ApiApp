package sree.ddukk.apiecom.ui.Apicalls

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import sree.ddukk.apiecom.ui.Models.modelItem

class ProductViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<modelItem>>(emptyList())
    val products: StateFlow<List<modelItem>> get() = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getAllProducts()
                _products.value = response
                response.forEach {
                    println("Product image URL: ${it.images.firstOrNull()}")
                }
                println("API Response: $response")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
