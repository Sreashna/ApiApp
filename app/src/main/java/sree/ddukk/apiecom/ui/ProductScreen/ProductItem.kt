//package sree.ddukk.apiecom.ui.ProductScreen
//
//import androidx.annotation.OptIn
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.media3.common.util.Log
//import androidx.media3.common.util.UnstableApi
//import coil.compose.AsyncImage
//import sree.ddukk.apiecom.ui.Models.modelItem
//
//@OptIn(UnstableApi::class)
//@Composable
//fun ProductItem(product: modelItem) {
//    val imageUrl = product.images.firstOrNull()
//    Log.d("Image URL", imageUrl.toString())
//
//    Card(
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth()
//            .height(250.dp),
//        shape = RoundedCornerShape(8.dp),
////        elevation = 4.dp,  // Card shadow effect
////        backgroundColor = Color.LightGray // Card background color
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(12.dp),  // Padding inside the card
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            AsyncImage(
//                model = imageUrl,
//                contentDescription = product.title,
//                modifier = Modifier
//                    .size(120.dp)
//                    .padding(bottom = 8.dp)
//            )
//            Text(
//                text = product.title,
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Black,
//                modifier = Modifier.padding(bottom = 4.dp)
//            )
//            Text(
//                text = "Description: ${product.description}",
//                fontSize = 14.sp,
//                color = Color.Gray,
//                modifier = Modifier.padding(bottom = 4.dp)
//            )
//            Text(
//                text = "Price: ₹${product.price}",
//                fontSize = 16.sp,
//                color = Color.Black,
//                modifier = Modifier.padding(bottom = 4.dp)
//            )
//            Text(
//                text = "Category: ${product.category.name}",
//                fontSize = 14.sp,
//                color = Color.Gray
//            )
//        }
//    }
//}