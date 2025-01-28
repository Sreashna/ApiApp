package sree.ddukk.apiecom.ui.ProductScreen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import sree.ddukk.apiecom.ui.Models.modelItem

val DeepCrimson = Color(0xFF740938)
val CrimsonRed = Color(0xFFAF1740)
val VividRed = Color(0xFFCC2B52)
val LightRed = Color(0xFFDE7C7D)
val DarkRed = Color(0xFF740938)
val MediumRed = Color(0xFFAF1740)
val BrightRed = Color(0xFFCC2B52)
val MutedRed = Color(0xFFDE7C7D)

@Composable
fun ProductDetailScreen(product: modelItem) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                AsyncImage(
                    model = product.images.firstOrNull(),
                    contentDescription = "Main Image of ${product.title}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = product.title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = VividRed,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "₹${product.price}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = CrimsonRed,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = product.description,
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Text(
                        text = "Category: ${product.category.name}",
                        fontSize = 16.sp,
                        color = DarkRed,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BrightRed)
                ) {
                    Text(text = "Buy Now", color = Color.White, fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = MediumRed)
                ) {
                    Text(text = "Add to Cart", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            if (product.images.size > 1) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "More Images",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = VividRed,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        product.images.drop(1).forEach { imageUrl ->
                            AsyncImage(
                                model = imageUrl,
                                contentDescription = "Additional image of ${product.title}",
                                modifier = Modifier
                                    .size(200.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )
                        }
                    }
                }
            }
        }
    }
}
