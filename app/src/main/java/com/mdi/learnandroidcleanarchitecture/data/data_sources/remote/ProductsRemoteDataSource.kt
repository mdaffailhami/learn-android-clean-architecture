package com.mdi.learnandroidcleanarchitecture.data.data_sources.remote

import arrow.core.Either
import com.mdi.learnandroidcleanarchitecture.core.RequestFailure
import com.mdi.learnandroidcleanarchitecture.core.apiUrl
import com.mdi.learnandroidcleanarchitecture.data.models.ProductModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import org.json.JSONArray

class ProductsRemoteDataSource(private val httpClient: HttpClient) {
    suspend fun getProducts(): Either<RequestFailure, List<ProductModel>> {
        return try {
            val response = httpClient.get("$apiUrl/products")
            val json = JSONArray(response.bodyAsText())

            val products = List(json.length()) { i ->
                ProductModel.fromJson(json.getJSONObject(i))
            }

            Either.Right(products)
        } catch (e: Exception) {
            Either.Left(RequestFailure(e.message ?: "Request failed"))
        }
    }
}