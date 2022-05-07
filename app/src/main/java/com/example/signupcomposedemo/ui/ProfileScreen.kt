package com.example.signupcomposedemo.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signupcomposedemo.EcommerceData
import com.example.signupcomposedemo.EcommerceItemStyle
import com.example.signupcomposedemo.R
import com.example.signupcomposedemo.ui.theme.AquaBlue
import com.example.signupcomposedemo.ui.theme.DeepBlue
import com.example.signupcomposedemo.ui.theme.TextWhite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ProfileScreen(
    name: String,
    email: String

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = DeepBlue,
                shape = RectangleShape
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileEcommerce(name, email)
    }
}

val eCommerceOptionsList: ArrayList<EcommerceData> = ArrayList()

@Composable
fun ProfileEcommerce(name: String, email: String) {
    var listPrepared by remember {
        mutableStateOf(false)
    }


    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            eCommerceOptionsList.clear()
            // Add the data to eCommerceOptionsList
            prepareECommerceData()

            listPrepared = true
        }
    }
    if (listPrepared) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {

            item {
                // User's image, name, email and edit button
                UserDetails(name, email)
            }

            // Show the options
            items(eCommerceOptionsList) { item ->
                EcommerceItemStyle(item = item)
            }

        }
    }

}

@Composable
fun UserDetails(name: String, email: String) {

    val context = LocalContext.current.applicationContext

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // User's image
        Image(
            modifier = Modifier
                .size(72.dp)
                .clip(shape = CircleShape),
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Your Image",

            )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(weight = 3f, fill = false)
                    .padding(start = 16.dp)
            ) {

                // User's name
                Text(
                    text = name,
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = TextWhite,
                        fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold)),
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(2.dp))

                // User's email
                Text(
                    text = email,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                        color = AquaBlue,
                        letterSpacing = (0.8).sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Edit button
            IconButton(
                modifier = Modifier
                    .weight(weight = 1f, fill = false),
                onClick = {
                    Toast.makeText(context, "Edit Button", Toast.LENGTH_SHORT).show()
                }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "Edit Details",
                    tint = AquaBlue
                )
            }

        }
    }
}

private fun prepareECommerceData() {

    val appIcons = Icons.Outlined

    eCommerceOptionsList.add(
        EcommerceData(
            icon = appIcons.Person,
            title = "Account",
            subTitle = "Manage your account"
        )
    )

    eCommerceOptionsList.add(
        EcommerceData(
            icon = appIcons.ShoppingCart,
            title = "Orders",
            subTitle = "Orders history"
        )
    )

    eCommerceOptionsList.add(
        EcommerceData(
            icon = appIcons.LocationOn,
            title = "Addresses",
            subTitle = "Your saved addresses"
        )
    )

    eCommerceOptionsList.add(
        EcommerceData(
            icon = appIcons.Add,
            title = "Saved Cards",
            subTitle = "Your saved debit/credit cards"
        )
    )

    eCommerceOptionsList.add(
        EcommerceData(
            icon = appIcons.Settings,
            title = "Settings",
            subTitle = "App notification settings"
        )
    )

    eCommerceOptionsList.add(
        EcommerceData(
            icon = appIcons.Check,
            title = "Help Center",
            subTitle = "FAQs and customer support"
        )
    )

    eCommerceOptionsList.add(
        EcommerceData(
            icon = appIcons.AccountCircle,
            title = "Offers and Coupons",
            subTitle = "Offers and coupon codes for you"
        )
    )

    eCommerceOptionsList.add(
        EcommerceData(
            icon = appIcons.FavoriteBorder,
            title = "Wishlist",
            subTitle = "Items you saved"
        )
    )
}



