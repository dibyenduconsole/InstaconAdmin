package com.buzzbites.instaconadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.buzzbites.instaconadmin.base.BaseActivity;
import com.buzzbites.instaconadmin.data.ProductItem;
import com.buzzbites.instaconadmin.viewmodel.ArticleViewModel;

import java.util.List;

public class HostActivity extends BaseActivity {

    ArticleViewModel articleViewModel;
    TextView tvProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        tvProduct = findViewById(R.id.tvProduct);

        // View Model
        articleViewModel = new ViewModelProvider(this).get(ArticleViewModel.class);
        articleViewModel.getArticleLiveData().observe(this, new Observer<List<ProductItem>>() {
            @Override
            public void onChanged(List<ProductItem> productItems) {

                productItems.forEach(d->{
                    tvProduct.setText(""+d.getTitle());
                });
                //tvProduct.text = it.joinToString { x -> x.title +"\n" }
            }
        });

    }
}