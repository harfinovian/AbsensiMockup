package indogrosir.id.indogrosirabsen.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import indogrosir.id.indogrosirabsen.R;

public class BaseActivity extends AppCompatActivity{

    public static final long DISCONNECT_TIMEOUT = 900000; // 5 min = 5 * 60 * 1000 ms

    protected void openNewActivity(Class activity) {
        startActivity(new Intent(this, activity));
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

//    public void settingContentView(int ly){
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        super.setContentView(ly);
//
//        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "font/proximanova_regular.otf");
//        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
//    }

    protected void openAndFinishActivity(Class activity){
        startActivity(new Intent(this, activity));
        finish();
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    protected void hideKeyboard(){
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void selectButtonColorDisable(Boolean param, Button btnParam){
        if(param){
            btnParam.setBackgroundColor(getResources().getColor(R.color.colorBackground));
        }else {
            btnParam.setBackgroundColor(Color.GRAY);
        }
    }

    protected void showDialogProgress(ProgressDialog progressDialog){
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("Please Waiting.."); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
    }

    protected void detailToolbar (ActionBar ab, String title){
        ab.setTitle(title);
        ab.setHomeAsUpIndicator(R.drawable.back_button_icon); // set a custom icon for the default home button
        ab.setDisplayShowHomeEnabled(true); // show or hide the default home button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true); // enable overriding the default toolbar layout
    }

    protected void errorRetrofit(Throwable t){
        Toast.makeText(this, "Tidak ada internet", Toast.LENGTH_SHORT).show();
        Log.e("error", t.getMessage());
    }
    protected void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        return true;
    }
}

