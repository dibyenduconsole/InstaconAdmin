package com.buzzbites.instaconadmin;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.buzzbites.instaconadmin.base.BaseActivity;
import com.buzzbites.instaconadmin.data.ProductItem;
import com.buzzbites.instaconadmin.viewmodel.HostViewModel;

import java.util.List;

public class HostActivity extends BaseActivity {

    HostViewModel hostViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hostViewModel = new ViewModelProvider(this).get(HostViewModel.class);
        setContentView(R.layout.activity_host);

        hostViewModel.showLoaderLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean result) {
                Log.d("TAG", "Activity show loader:: " + result);
                if(result){
                    showProgress("Loading");
                }else {
                    hideProgress();
                }
            }
        });

    }
}