package com.buzzbites.instaconadmin.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.buzzbites.instaconadmin.data.ProductItem;
import com.buzzbites.instaconadmin.data.response.ApiResponse;
import com.buzzbites.instaconadmin.data.response.Rating;
import com.buzzbites.instaconadmin.data.response.ResponseCallValue;
import com.buzzbites.instaconadmin.retrofit.ApiRequest;
import com.buzzbites.instaconadmin.retrofit.RetrofitRequest;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG = ArticleRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public ArticleRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public LiveData<List<ProductItem>> getProducts() {
        final MutableLiveData<List<ProductItem>> data = new MutableLiveData<>();
        isLoading.postValue(true);
        apiRequest.getProducts()
                .enqueue(apiCallBackResponse);
        return data;
    }

    Callback apiCallBackResponse = new Callback<ApiResponse>() {
        @Override
        public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
            Gson gson = new Gson();
            isLoading.postValue(false);
            Log.d(TAG, "onResponse response:: " + response);
            Log.d(TAG, ":: " + response.raw());
            String dd = response.raw().toString().replace("Response","");
            Log.d(TAG, ":: " + dd);
            ResponseCallValue callValue = gson.fromJson(response.raw().toString().replace("Response",""), ResponseCallValue.class);
            //Log.d(TAG, "callValue :: " + callValue.getUrl());

            if (response.body() != null) {
                //data.setValue(response.body());
                Log.d(TAG, "articles total result:: " + response.body().getRating());
                Log.d(TAG, "articles size:: " + response.body().getTitle());


                Rating rating = gson.fromJson(response.body().getRating().toString(), Rating.class);
                Log.d(TAG, "rating :: " + rating.getRate());
                //Log.d(TAG, "articles title pos 0:: " + response.body().getArticles().get(0).getTitle());
            }
        }

        @Override
        public void onFailure(Call<ApiResponse> call, Throwable t) {
            isLoading.postValue(false);

        }
    };
}
