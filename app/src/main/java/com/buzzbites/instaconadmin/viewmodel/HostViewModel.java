package com.buzzbites.instaconadmin.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.buzzbites.instaconadmin.data.ProductItem;
import com.buzzbites.instaconadmin.repository.ArticleRepository;

import java.util.List;

public class HostViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private LiveData<List<ProductItem>> articleResponseLiveData;
    private LiveData<Boolean> isLoading;

    public HostViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new ArticleRepository();
        this.isLoading = articleRepository.getIsLoading();
    }

    public LiveData<List<ProductItem>> getArticleLiveData() {
        return articleResponseLiveData;
    }
    public LiveData<Boolean> showLoaderLiveData(){
        return isLoading;
    }

    public ArticleRepository getArticleRepository() {
        return articleRepository;
    }

    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
}
