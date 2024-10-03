package com.mdi.learnandroidcleanarchitecture.data.repositories

import arrow.core.Either
import arrow.core.left
import com.mdi.learnandroidcleanarchitecture.core.RequestFailure
import com.mdi.learnandroidcleanarchitecture.data.data_sources.remote.ProductsRemoteDataSource
import com.mdi.learnandroidcleanarchitecture.data.models.ProductModel
import com.mdi.learnandroidcleanarchitecture.domain.entities.ProductEntity
import com.mdi.learnandroidcleanarchitecture.domain.repositories.ProductsRepository

class ProductsRepositoryImpl(private val productsRemoteDataSource: ProductsRemoteDataSource) :
    ProductsRepository {
    override suspend fun getProducts(): Either<RequestFailure, List<ProductEntity>> {
        val productModels = productsRemoteDataSource.getProducts()

        return productModels.fold(
            { Either.Left(it) },
            {
                val productEntities = List(it.size) { i ->
                    ProductEntity.fromProductModel(it[i])
                }

                Either.Right(productEntities)
            }
        )
    }
}