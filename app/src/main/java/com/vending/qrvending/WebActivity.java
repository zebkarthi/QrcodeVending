package com.vending.qrvending;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebActivity extends AppCompatActivity {

//    private SharedPreferences savednotes;
    private WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.web_activity);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webView.clearHistory();
        webView.clearFormData();
        webView.clearCache(true);

//        savednotes = getSharedPreferences("notes", MODE_PRIVATE);
//        String lat = savednotes.getString("barcode", "");//"No name" = default value.
        webView.loadUrl("http://iotonline.xyz/karthi/vent/vent/");

        progressBar = (ProgressBar) findViewById(R.id .progressBar);

        webView.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {


                super.onPageStarted(view, url, favicon);

                progressBar.setVisibility(View.VISIBLE);




            }


            @Override
            public void onPageFinished(WebView view, String url) {


                progressBar.setVisibility(View.GONE);


            }

        });
    }
}
