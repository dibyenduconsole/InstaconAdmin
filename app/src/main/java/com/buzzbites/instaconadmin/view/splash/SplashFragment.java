package com.buzzbites.instaconadmin.view.splash;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buzzbites.instaconadmin.HostActivity;
import com.buzzbites.instaconadmin.R;
import com.buzzbites.instaconadmin.databinding.FragmentSplashBinding;
import com.buzzbites.instaconadmin.viewmodel.HostViewModel;

public class SplashFragment extends Fragment {

    private FragmentSplashBinding binding;
    private SplashViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(SplashViewModel.class);
        binding = FragmentSplashBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.executeAPIcall();
            }
        });

        viewModel.showLoaderLiveData().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean result) {
                Log.d("TAG", "show loader:: " + result);
                if(result){
                    ((HostActivity)getActivity()).showProgress("Loading");
                }else {
                    ((HostActivity)getActivity()).hideProgress();
                }

            }
        });

    }
}