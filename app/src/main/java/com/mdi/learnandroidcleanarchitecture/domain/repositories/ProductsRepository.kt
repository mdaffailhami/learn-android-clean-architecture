package com.mdi.learnandroidcleanarchitecture.domain.repositories

import arrow.core.Either
import com.mdi.learnandroidcleanarchitecture.core.RequestFailure
import com.mdi.learnandroidcleanarchitecture.domain.entities.ProductEntity

interface ProductsRepository {
    suspend fun getProducts(): Either<RequestFailure ,List<ProductEntity>>
}
