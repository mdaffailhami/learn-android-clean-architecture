package com.mdi.learnandroidcleanarchitecture.presentation.view_models

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdi.learnandroidcleanarchitecture.core.RequestFailure
import com.mdi.learnandroidcleanarchitecture.core.RequestState
import com.mdi.learnandroidcleanarchitecture.domain.entities.ProductEntity
import com.mdi.learnandroidcleanarchitecture.domain.use_cases.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val getProductsUseCase: GetProductsUseCase) :
    ViewModel() {
    val state = mutableStateOf(RequestState.Loading)
    val value = mutableStateListOf<ProductEntity>()
    var error: RequestFailure? = null

    fun load() {
        viewModelScope.launch {
            state.value = RequestState.Loading

            val products = getProductsUseCase()

            products.fold(
                {
                    error = it
                    state.value = RequestState.Failed
                },
                {
                    value.clear()
                    value.addAll(it)
                    state.value = RequestState.Loaded
                }
            )
        }
    }

}
