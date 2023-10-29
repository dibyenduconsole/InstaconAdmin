package com.buzzbites.instaconadmin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.buzzbites.instaconadmin.retrofit.RetrofitAPI
import com.buzzbites.instaconadmin.data.ProductItem
import javax.inject.Inject

class ProductRepository @Inject constructor(private val retrofitAPI: RetrofitAPI) {

    private val _products = MutableLiveData<List<ProductItem>>()
    val products: LiveData<List<ProductItem>>
    get() = _products

    suspend fun getProducts(){
        val result = retrofitAPI.getProducts()
        if(result.isSuccessful && result.body() != null){
            _products.postValue(result.body())
        }
    }

}