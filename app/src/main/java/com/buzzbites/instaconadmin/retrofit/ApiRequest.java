package com.buzzbites.instaconadmin.retrofit;

import com.buzzbites.instaconadmin.data.ProductItem;
import com.buzzbites.instaconadmin.data.response.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("products/1")
    Call<ApiResponse> getProducts();
}
