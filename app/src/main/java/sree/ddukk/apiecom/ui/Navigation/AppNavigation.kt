package sree.ddukk.apiecom.ui.Navigation

import ProductListScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import sree.ddukk.apiecom.ui.Models.modelItem
import sree.ddukk.apiecom.ui.ProductScreen.ProductDetailScreen
import com.google.gson.Gson
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.navigation.compose.currentBackStackEntryAsState
import sree.ddukk.apiecom.ui.CategoryScreen.CategoryScreen
import sree.ddukk.apiecom.ui.UserScreen.UsersScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val gson = Gson()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
                elevation = 8.dp
            ) {
                BottomNavigationItem(
                    selected = currentRoute == "productList",
                    onClick = { navController.navigate("productList") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home"
                        )
                    },
                    label = { Text("Home") }
                )
                BottomNavigationItem(
                    selected = currentRoute == "category",
                    onClick = { navController.navigate("category") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Category,
                            contentDescription = "Category"
                        )
                    },
                    label = { Text("Category") }
                )
                BottomNavigationItem(
                    selected = currentRoute == "users",
                    onClick = { navController.navigate("users") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Users"
                        )
                    },
                    label = { Text("Users") }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "productList",
            modifier = Modifier.padding(innerPadding) // To avoid overlap with bottom bar
        ) {
            composable("productList") {
                ProductListScreen(navController = navController)
            }
            composable(
                route = "productDetail/{productJson}",
                arguments = listOf(navArgument("productJson") { type = NavType.StringType })
            ) { backStackEntry ->
                val productJson = backStackEntry.arguments?.getString("productJson") ?: ""
                val product = gson.fromJson(productJson, modelItem::class.java)
                ProductDetailScreen(product = product)
            }
            composable("category") {
                CategoryScreen()
            }
            composable("users") {
                UsersScreen()
            }
        }
    }
}
