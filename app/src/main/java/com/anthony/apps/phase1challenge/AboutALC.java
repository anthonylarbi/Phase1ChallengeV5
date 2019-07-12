package com.anthony.apps.phase1challenge;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALC extends AppCompatActivity {
 WebView vmView;
 String url = "https://andela.com/alc/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_about_alc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vmView= findViewById(R.id.alcpage);
        vmView.getSettings().setAppCacheEnabled(true);
        vmView.getSettings().setDatabaseEnabled(true);
        vmView.getSettings().setDomStorageEnabled(true);
        vmView.getSettings().setSupportZoom(true);
        vmView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        vmView.getSettings().setBuiltInZoomControls(true);

        vmView.getSettings().setGeolocationEnabled(true);
        vmView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler
                    handler, SslError error) {
                handler.proceed();
            }
        });

        vmView.loadUrl("https://andela.com/alc/");

        vmView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });



        //vmView= findViewById(R.id.alcpage);
       // vmView.setWebViewClient(new WebViewClient());
       //vmView.getSettings().setJavaScriptEnabled(true);
     // vmView.loadUrl(url);


    }

}
