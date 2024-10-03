package com.mdi.learnandroidcleanarchitecture.domain.entities

import com.mdi.learnandroidcleanarchitecture.data.models.ProductModel

data class ProductEntity(
    var title: String,
    var price: Double,
    var description: String,
    var image: String,
    var rating: Double
) {
    companion object {
        fun fromProductModel(productModel: ProductModel): ProductEntity {
            return ProductEntity(
                title = productModel.title,
                price = productModel.price,
                description = productModel.description,
                image = productModel.image,
                rating = productModel.rating.rate
            )
        }
    }
}
