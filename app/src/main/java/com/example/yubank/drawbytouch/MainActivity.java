package com.example.yubank.drawbytouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView webView;

    @JavascriptInterface
    public void pageClose() { // must be final
        Toast.makeText(MainActivity.this, "Page Close 요청", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        // 웹뷰에서 자바스크립트실행가능
        WebSettings webSettings = webView.getSettings();
        webSettings.setSaveFormData(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webView.addJavascriptInterface(this, "Android");

        webView.setWebViewClient(new WebViewClient() );
        webView.setWebChromeClient(new WebChromeClient());

        webView.loadUrl("file:///android_asset/html/drawImgBackup.html");
    }
}
