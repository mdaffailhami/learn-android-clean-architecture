package com.mdi.learnandroidcleanarchitecture.domain.repositories

import com.mdi.learnandroidcleanarchitecture.domain.entities.ProductEntity

interface ProductsRepository {
    suspend fun getProducts(): List<ProductEntity>
}
