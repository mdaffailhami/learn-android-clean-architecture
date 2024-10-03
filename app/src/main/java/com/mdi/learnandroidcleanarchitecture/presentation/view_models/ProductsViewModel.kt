package com.mdi.learnandroidcleanarchitecture.presentation.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdi.learnandroidcleanarchitecture.domain.entities.ProductEntity
import com.mdi.learnandroidcleanarchitecture.domain.use_cases.GetProductsUseCase
import kotlinx.coroutines.launch

class ProductsViewModel(private val getProductsUseCase: GetProductsUseCase) : ViewModel() {
    var value = mutableStateListOf<ProductEntity>()

    fun load(): Unit {
        viewModelScope.launch {
            value.clear()
            value.addAll(getProductsUseCase())
        }
    }

}
