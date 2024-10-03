package com.mdi.learnandroidcleanarchitecture.data.data_sources.remote

import com.mdi.learnandroidcleanarchitecture.core.apiUrl
import com.mdi.learnandroidcleanarchitecture.core.httpClient
import com.mdi.learnandroidcleanarchitecture.data.models.ProductModel
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import org.json.JSONArray

class ProductsRemoteDataSource {
    suspend fun getProducts(): List<ProductModel> {
        val response = httpClient.get("$apiUrl/products")
        val json = JSONArray(response.bodyAsText())

        val products = List(json.length()) { i ->
            ProductModel.fromJson(json.getJSONObject(i))
        }

        return products
    }
}