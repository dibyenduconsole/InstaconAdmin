package com.buzzbites.instaconadmin.base;

public interface BaseView {

    void showProgress(String message);

    void hideProgress();

    void showError(String message);
}
