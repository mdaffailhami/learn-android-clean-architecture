package com.mdi.learnandroidcleanarchitecture.domain.use_cases

import arrow.core.Either
import com.mdi.learnandroidcleanarchitecture.core.RequestFailure
import com.mdi.learnandroidcleanarchitecture.domain.entities.ProductEntity
import com.mdi.learnandroidcleanarchitecture.domain.repositories.ProductsRepository

class GetProductsUseCase(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke(): Either<RequestFailure, List<ProductEntity>> {
        return productsRepository.getProducts();
    }
}