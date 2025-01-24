package sree.ddukk.apiecom.ui.Navigation

import ProductListScreen
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import sree.ddukk.apiecom.ui.Models.Category
import sree.ddukk.apiecom.ui.Models.modelItem
import sree.ddukk.apiecom.ui.ProductDetailScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "productList") {
        // The Product List Screen
        composable("productList") {
            ProductListScreen(navController = navController)  // Pass navController here
        }

        // The Product Detail Screen
        composable(
            route = "productDetail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: -1
            // Here, you would normally get the product from your ViewModel or repository
            val product = getProductById(productId)  // Replace this with actual logic
            ProductDetailScreen(product = product)
        }
    }
}
fun getProductById(productId: Int): modelItem {
    // Replace this with actual logic to fetch product details
    return modelItem(
        category = Category(creationAt = "2023-01-01", id = 1, image = "image_url", name = "Category 1", updatedAt = "2023-01-01"),
        creationAt = "2023-01-01",
        description = "Sample Product Description",
        id = productId,
        images = listOf("image_url"),
        price = 999,
        title = "Sample Product",
        updatedAt = "2023-01-01"
    )
}
