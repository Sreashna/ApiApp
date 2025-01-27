
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import sree.ddukk.apiecom.ui.Apicalls.ProductViewModel
import sree.ddukk.apiecom.ui.ProductScreen.ProductItem
import sree.ddukk.apiecom.ui.ProductScreen.ShimmerItem
@Composable
fun ProductListScreen(viewModel: ProductViewModel = viewModel(), navController: NavController) {
    val isLoading by viewModel.isLoading.collectAsState()
    val products by viewModel.products.collectAsState()
    val gson = Gson()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        if (isLoading) {
            items(6) {
                ShimmerItem() 
            }
        } else {
            items(products) { product ->
                ProductItem(
                    product = product,
                    navController = navController,
                    isLoading = false
                ) {
                    val productJson = Uri.encode(gson.toJson(product))
                    navController.navigate("productDetail/$productJson")
                }
            }
        }
    }
}