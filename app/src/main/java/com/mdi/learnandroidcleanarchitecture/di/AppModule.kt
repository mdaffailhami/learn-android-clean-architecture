package com.mdi.learnandroidcleanarchitecture.di

import com.mdi.learnandroidcleanarchitecture.data.data_sources.remote.ProductsRemoteDataSource
import com.mdi.learnandroidcleanarchitecture.data.repositories.ProductsRepositoryImpl
import com.mdi.learnandroidcleanarchitecture.domain.repositories.ProductsRepository
import com.mdi.learnandroidcleanarchitecture.domain.use_cases.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideHttpClient():HttpClient{
        return HttpClient(CIO)
    }

    @Provides
    @Singleton
    fun provideProductsRemoteDataSource(httpClient: HttpClient):ProductsRemoteDataSource{
        return ProductsRemoteDataSource(httpClient)
    }

    @Provides
    @Singleton
    fun provideProductsRepository(productsRemoteDataSource: ProductsRemoteDataSource):ProductsRepository{
        return ProductsRepositoryImpl(productsRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetProductsUseCase(productsRepository: ProductsRepository):GetProductsUseCase{
        return GetProductsUseCase(productsRepository)
    }
}