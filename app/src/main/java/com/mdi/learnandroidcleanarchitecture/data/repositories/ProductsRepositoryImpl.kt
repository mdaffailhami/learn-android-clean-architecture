package com.mdi.learnandroidcleanarchitecture.data.repositories

import com.mdi.learnandroidcleanarchitecture.data.data_sources.remote.ProductsRemoteDataSource
import com.mdi.learnandroidcleanarchitecture.data.models.ProductModel
import com.mdi.learnandroidcleanarchitecture.domain.entities.ProductEntity
import com.mdi.learnandroidcleanarchitecture.domain.repositories.ProductsRepository

class ProductsRepositoryImpl(private val productsRemoteDataSource: ProductsRemoteDataSource):ProductsRepository {
    override suspend fun getProducts(): List<ProductEntity> {
        val productModels = productsRemoteDataSource.getProducts()

        val productEntities = List(productModels.size) { i ->
            ProductEntity.fromProductModel(productModels[i])
        }

        return productEntities
    }
}