package com.buzzbites.instaconadmin.view.splash;

import android.app.Application;

import androidx.annotation.NonNull;

import com.buzzbites.instaconadmin.viewmodel.HostViewModel;

public class SplashViewModel extends HostViewModel {
    public SplashViewModel(@NonNull Application application) {
        super(application);
    }

    public void executeAPIcall(){
        getArticleRepository().getProducts();
    }

}
