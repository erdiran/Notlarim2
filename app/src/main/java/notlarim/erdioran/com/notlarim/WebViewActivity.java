package notlarim.erdioran.com.notlarim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView myWebView;
    private WebChromeClient webChromeClient;
    private String url;
    private AppCompatActivity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        activity = this;
        Fabric.with(activity, new Crashlytics());

        Bundle bundle = getIntent().getExtras();
        url = bundle.getString("url");
        webChromeClient = new WebChromeClient();

        myWebView = (WebView) findViewById(R.id.myWebView);
        myWebView.setWebChromeClient(webChromeClient);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl(url);
    }

    @Override
    public void onClick(View view) {

    }
}
