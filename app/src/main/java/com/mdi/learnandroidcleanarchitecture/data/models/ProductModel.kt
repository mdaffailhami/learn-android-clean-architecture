package com.mdi.learnandroidcleanarchitecture.data.models

import org.json.JSONObject

data class ProductModel (
    var id: Int,
    var title: String,
    var price: Double,
    var description: String,
    var category: String,
    var image: String,
    var rating: RatingModel
) {
    companion object {
        fun fromJson(json: JSONObject): ProductModel {
            return ProductModel(
                id = json.getInt("id"),
                title = json.getString("title"),
                price = json.getDouble("price"),
                description = json.getString("description"),
                category = json.getString("category"),
                image = json.getString("image"),
                rating = RatingModel.fromJson(json.getJSONObject("rating"))
            )
        }
    }
}