package com.mdi.learnandroidcleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.mdi.learnandroidcleanarchitecture.data.data_sources.remote.ProductsRemoteDataSource
import com.mdi.learnandroidcleanarchitecture.data.repositories.ProductsRepositoryImpl
import com.mdi.learnandroidcleanarchitecture.domain.use_cases.GetProductsUseCase
import com.mdi.learnandroidcleanarchitecture.presentation.pages.HomePage
import com.mdi.learnandroidcleanarchitecture.presentation.view_models.ProductsViewModel
import com.mdi.learnandroidcleanarchitecture.ui.theme.LearnAndroidCleanArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MyApp() }
    }
}

@Composable
fun MyApp() {
    val productsViewModel = ProductsViewModel(
        GetProductsUseCase(
            ProductsRepositoryImpl(
                ProductsRemoteDataSource()
            )
        )
    )

    LearnAndroidCleanArchitectureTheme(
        dynamicColor = false,
        darkTheme = false
    ) {
        HomePage(productsViewModel)
    }
}