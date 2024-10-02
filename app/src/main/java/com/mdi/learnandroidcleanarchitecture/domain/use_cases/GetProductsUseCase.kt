package com.mdi.learnandroidcleanarchitecture.domain.use_cases

import com.mdi.learnandroidcleanarchitecture.domain.entities.ProductEntity
import com.mdi.learnandroidcleanarchitecture.domain.repositories.ProductsRepository

class GetProductsUseCase(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke():List<ProductEntity>{
        return productsRepository.getProducts();
    }
}