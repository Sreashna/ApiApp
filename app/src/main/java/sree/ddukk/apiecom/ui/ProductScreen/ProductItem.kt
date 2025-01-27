package sree.ddukk.apiecom.ui.ProductScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import sree.ddukk.apiecom.ui.Models.modelItem

@Composable
fun ProductItem(
    product: modelItem,
    navController: NavController,
    isLoading: Boolean,
    onClick: () -> Unit // Pass navigation logic as a lambda
) {
    if (isLoading) {
        ShimmerItem() // Render the shimmer effect
    } else {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(250.dp)
                .clickable(onClick = onClick), // Trigger onClick when clicked
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = product.images.firstOrNull(),
                    contentDescription = product.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .graphicsLayer {
                            shape = RoundedCornerShape(18.dp)
                            clip = true
                        }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = product.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Price: ₹${product.price}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 8.dp)
                )
            }
        }
    }
}