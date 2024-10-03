package com.mdi.learnandroidcleanarchitecture.data.models

import org.json.JSONObject

data class RatingModel (
    var rate: Double,
    var count: Int
) {
    companion object {
        fun fromJson(json: JSONObject): RatingModel {
            return RatingModel(
                rate = json.getDouble("rate"),
                count = json.getInt("count"),
            )
        }
    }
}