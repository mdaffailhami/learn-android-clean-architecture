package com.mdi.learnandroidcleanarchitecture.presentation.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.left
import arrow.core.right
import com.mdi.learnandroidcleanarchitecture.core.RequestFailure
import com.mdi.learnandroidcleanarchitecture.domain.entities.ProductEntity
import com.mdi.learnandroidcleanarchitecture.domain.use_cases.GetProductsUseCase
import kotlinx.coroutines.launch

class ProductsViewModel(private val getProductsUseCase: GetProductsUseCase) : ViewModel() {
    val value = mutableStateListOf<ProductEntity>()
    val isLoading = mutableStateOf(false)
    val error = mutableStateOf<RequestFailure?>(null)

    fun load(): Unit {
        viewModelScope.launch {
            isLoading.value = true

            val products = getProductsUseCase()

            products.fold(
                {error.value = it},
                {
                    value.clear()
                    value.addAll(it)
                }
            )

            isLoading.value = false
        }
    }

}
