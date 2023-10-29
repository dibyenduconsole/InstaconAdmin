package com.buzzbites.instaconadmin.retrofit

import com.buzzbites.instaconadmin.data.ProductItem
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("products")
    suspend fun getProducts():Response<List<ProductItem>>
}