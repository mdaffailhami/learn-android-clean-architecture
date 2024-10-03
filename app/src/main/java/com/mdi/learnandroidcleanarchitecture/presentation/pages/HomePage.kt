package com.mdi.learnandroidcleanarchitecture.presentation.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mdi.learnandroidcleanarchitecture.core.RequestState
import com.mdi.learnandroidcleanarchitecture.presentation.components.AppBar
import com.mdi.learnandroidcleanarchitecture.presentation.components.ProductCard
import com.mdi.learnandroidcleanarchitecture.presentation.view_models.ProductsViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomePage(productsViewModel: ProductsViewModel) {
    productsViewModel.load()

    Scaffold(topBar = { AppBar() }) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                if (productsViewModel.state.value == RequestState.Failed) {
                    Spacer(Modifier.height(100.dp))
                    productsViewModel.error?.let { Text(it.message) }
                }

                if (productsViewModel.state.value == RequestState.Loading) {
                    Spacer(Modifier.height(100.dp))
                    CircularProgressIndicator()
                }

                if (productsViewModel.state.value == RequestState.Loaded) {
                    FlowRow(
                        horizontalArrangement = Arrangement.Start,
                        verticalArrangement = Arrangement.Top
                    ) {
                        productsViewModel.value.forEach {
                            ProductCard(it)
                        }
                    }
                }
            }
        }

//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
//            horizontalArrangement = Arrangement.spacedBy(16.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            modifier = Modifier.padding(innerPadding)
//        ) {
//            items(productsViewModel.value) { product ->
//                ProductCard(product)
//            }
//        }
    }
}