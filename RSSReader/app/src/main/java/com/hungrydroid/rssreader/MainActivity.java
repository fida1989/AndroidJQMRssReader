package com.hungrydroid.rssreader;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView wv;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv = (WebView) findViewById(R.id.webview);
       wv.getSettings().setJavaScriptEnabled(true);

        wv.setHorizontalScrollBarEnabled(false);
        wv.setVerticalScrollBarEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_INSET);
        wv.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //wv.getSettings().setBuiltInZoomControls(true);
        wv.setWebViewClient(new myWebClient());
        wv.loadUrl("file:///android_asset/index.html");
    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            progress = new ProgressDialog(MainActivity.this);
            progress.setMessage("Loading...");
            progress.setIndeterminate(true);
            //progress.setCancelable(false);
            progress.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progress.dismiss();
        }
    }
}
