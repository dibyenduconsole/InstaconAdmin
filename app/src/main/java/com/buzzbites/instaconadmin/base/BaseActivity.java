package com.buzzbites.instaconadmin.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.buzzbites.instaconadmin.R;
import com.buzzbites.instaconadmin.receiver.ConnectivityReceiver;
import com.google.android.material.snackbar.Snackbar;


public abstract class BaseActivity extends AppCompatActivity implements BaseView, ConnectivityReceiver.ConnectivityReceiverListener {

    protected ProgressDialog progressDialog;
    DisplayMetrics displayMetrics = new DisplayMetrics();

    ConnectivityReceiver broadcastReceiver;

    Snackbar snackbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        broadcastReceiver = new ConnectivityReceiver();
    }

    protected void showProgressDialog(String message) {
        if (progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(message);
            progressDialog.setCanceledOnTouchOutside(false);
            if (!isFinishing()) {
                progressDialog.show();
            }
        }
    }

    protected void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            if (!isFinishing()) {
                progressDialog.dismiss();
            }
        }
    }

    protected void showDialog(final String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.app_name);
        if (message != null) {
            builder.setMessage(Html.fromHtml(message));
        } else {
            builder.setMessage("");
        }
        builder.setPositiveButton(android.R.string.ok, null);

        if (!isFinishing()) {
            builder.show();
        }
    }

    @Override
    public void showProgress(String message) {
        showProgressDialog(message);
    }

    @Override
    public void hideProgress() {
        hideProgressDialog();
    }

    @Override
    public void showError(String message) {
        showDialog(message);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

        showSnack(isConnected);
    }

    // Showing the status in Snackbar
    protected void showSnack(boolean isConnected) {
        String message;
        message = "Connection Lost: Check Your Internet.";

        if (isConnected) {
            if(snackbar !=null)
                snackbar.dismiss();
        } else {
            snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_INDEFINITE);
            snackbar.getView().setBackgroundColor(getResources().getColor(R.color.blue));
            snackbar.show();
        }
    }

    public int getDisplayWidth(){
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return width;
    }

    public int getDisplayHeight(){
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return height;
    }
    @Override
    protected void onResume() {
        super.onResume();
        try {
            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

            ConnectivityReceiver.connectivityReceiverListener = this;
        }catch (Exception e){

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(broadcastReceiver != null)
            unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void showShortToast(String msg){

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    }

    public void showLongToast(String msg){

        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();

    }

}
