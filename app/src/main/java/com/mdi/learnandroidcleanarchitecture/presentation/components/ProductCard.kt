package com.mdi.learnandroidcleanarchitecture.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mdi.learnandroidcleanarchitecture.domain.entities.ProductEntity

@Composable
fun ProductCard(product: ProductEntity) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(4))
    ) {
        Column(
            modifier = Modifier
                .size(width = 180.dp, height = 330.dp)
                .background(color = Color.White)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = "Product Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(8f)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(5f)
                    .padding(horizontal = 10.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = product.title,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 16.sp
                    )
                    Text(
                        text = product.description,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 10.sp,
                        lineHeight = 16.sp
                    )

                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "\$${product.price}",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.Magenta
                    )
                    Text(
                        text = "⭐${product.rating}",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 14.sp
                    )
                }
                Spacer(Modifier.height(10.dp))
            }
        }
    }
}
