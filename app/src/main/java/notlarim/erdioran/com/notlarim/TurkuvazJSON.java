package notlarim.erdioran.com.notlarim;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import org.json.JSONObject;

public class TurkuvazJSON extends Activity {

    private WebView webViewUyduBilgileri;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uydu_bilgileri);


        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        webViewUyduBilgileri = (WebView) findViewById(R.id.webViewUyduBilgileri);

        TurquazApi turquazApi = new TurquazApi(new TurquazApi.Listener() {
            @Override
            public void onSuccess(String jsonString) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    jsonObject = jsonObject.getJSONObject("data").getJSONObject("uyduBilgileri").getJSONObject("Response");
                    String title = jsonObject.getString("Title").toString();
                    String description = jsonObject.getString("Description").toString();

                    webViewUyduBilgileri.loadData(description, "text/html; charset=utf-8", "utf-8");
//                    getSupportActionBar().setTitle(title);
                } catch (Exception e) {
                }
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
        turquazApi.execute(Utils.API_URL);
    }
}
