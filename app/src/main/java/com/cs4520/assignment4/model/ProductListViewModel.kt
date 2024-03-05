package com.cs4520.assignment4.model

import androidx.lifecycle.ViewModel
import com.cs4520.assignment4.data.ApiService
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher


class ProductListViewModel(apiService: ApiService): ViewModel() {

    fun getAllProducts() {
    }
}