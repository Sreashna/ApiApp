import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Card
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.request.ImageRequest
import sree.ddukk.apiecom.ui.Apicalls.ProductViewModel
import sree.ddukk.apiecom.ui.Models.modelItem

@Composable
fun ProductListScreen(viewModel: ProductViewModel = viewModel(), navController: NavController) {
    val products by viewModel.products.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),  // Display two items per row
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentPadding = PaddingValues(8.dp) // Padding between grid items
    ) {
        items(products) { product ->
            ProductItem(product, navController)
        }
    }
}

@Composable
fun ProductItem(product: modelItem, navController: NavController) {
    val imageUrl = product.images.firstOrNull()
    Log.d("Image URL", imageUrl.toString())

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(250.dp)  // Define a fixed height for cards
            .clickable {
                // On card click, navigate to product details screen
                navController.navigate("productDetail/${product.id}")
            },
        shape = RoundedCornerShape(8.dp),  // Rounded corners for the card
//        elevation = 4.dp,  // Card shadow effect
//        backgroundColor = Color.LightGray // Card background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),  // Padding inside the card
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display image
            AsyncImage(
                model = imageUrl,
                contentDescription = product.title,
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 8.dp)
            )

            // Title
            Text(
                text = product.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Description
            Text(
                text = "Description: ${product.description}",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Price
            Text(
                text = "Price: ₹${product.price}",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Category
            Text(
                text = "Category: ${product.category.name}",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
