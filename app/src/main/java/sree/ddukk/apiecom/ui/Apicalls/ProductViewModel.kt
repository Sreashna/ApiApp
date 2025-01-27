package sree.ddukk.apiecom.ui.Apicalls

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import sree.ddukk.apiecom.ui.Models.modelItem

class ProductViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<modelItem>>(emptyList())
    val products: StateFlow<List<modelItem>> get() = _products

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            _isLoading.value = true // Set loading to true
            try {
                // Simulate network delay for demonstration
                delay(2000)
                val response = RetrofitClient.apiService.getAllProducts()
                _products.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false // Set loading to false
            }
        }
    }
}
