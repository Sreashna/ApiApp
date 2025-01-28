package sree.ddukk.apiecom.ui.UserScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import sree.ddukk.apiecom.ui.Models.User
import androidx.lifecycle.viewmodel.compose.viewModel
import sree.ddukk.apiecom.ui.ProductScreen.CrimsonRed
import sree.ddukk.apiecom.ui.ProductScreen.DarkRed
import sree.ddukk.apiecom.ui.ProductScreen.DeepCrimson
import sree.ddukk.apiecom.ui.ProductScreen.LightRed
import sree.ddukk.apiecom.ui.ProductScreen.UserViewModel
import sree.ddukk.apiecom.ui.ProductScreen.VividRed

@Composable
fun UsersScreen(viewModel: UserViewModel = viewModel()) {
    val users by viewModel.users.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = CrimsonRed)
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(12.dp),
        ) {
            Text(
                text = "User Profiles",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = DeepCrimson,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            users.forEach { user ->
                UserCard(user = user)
            }
        }
    }
}

@Composable
fun UserCard(user: User) {
    Card(
        modifier = Modifier
//            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = user.avatar,
                contentDescription = "User Avatar",
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(60.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = user.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkRed,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = user.email,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "User ID: ${user.id}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = VividRed
                )
            }
        }
    }
}
