package com.mdi.learnandroidcleanarchitecture.presentation.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mdi.learnandroidcleanarchitecture.presentation.view_models.ProductsViewModel

@Composable
fun HomePage(productsViewModel: ProductsViewModel) {
    productsViewModel.load()

    Scaffold { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(productsViewModel.value) { product ->
                Text(product.title)
                println(product)
            }
        }
    }
}