package notlarim.erdioran.com.notlarim;

import android.os.AsyncTask;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class TurquazApi extends AsyncTask<String, String, String> {
    private Listener listener;
    private List<NameValuePair> nameValuePair;
    private String bearerTokenHeader;
    private JSONObject jsonObject;

    public TurquazApi(Listener listener) {
        this.listener = listener;
    }

    public void addNameValuepair(String key, String value) {
        if(nameValuePair == null) nameValuePair = new ArrayList<>();
        nameValuePair.add(new BasicNameValuePair(key, value));
    }

    public void setBearerTokenHeader(String bearerTokenHeader) {
        this.bearerTokenHeader = bearerTokenHeader;
    }

    @Override
    protected String doInBackground(String... urls) {
        String jsonResult = "";
        HttpResponse response = null;
        try {
            HttpParams httpParams = new BasicHttpParams();
            HttpClient httpclient = new DefaultHttpClient(httpParams);

            HttpConnectionParams.setConnectionTimeout(httpParams, 60000);
            HttpConnectionParams.setSoTimeout(httpParams, 60000);

            if(nameValuePair == null && jsonObject == null) {
                HttpGet httpGet = new HttpGet(urls[0]);
                httpGet.setHeader("Accept", "application/json");
                httpGet.setHeader("Content-type", "application/json; charset=utf-8;");
                //httppost.setHeader("Cache-Control", "max-age=600");
                response = httpclient.execute(httpGet);
            }

            if(nameValuePair != null) {
                HttpPost httppost = new HttpPost(urls[0]);
                if(bearerTokenHeader != null) {
                    httppost.addHeader("Authorization", bearerTokenHeader);
                    httppost.setHeader("Content-type", "application/x-www-form-urlencoded");
                }
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePair));
                response = httpclient.execute(httppost);
            }

            if(jsonObject != null) {
                HttpPost httppost = new HttpPost(urls[0]);
                httppost.setHeader("Accept", "application/json");
                httppost.setHeader("Content-type", "application/json; charset=utf-8;");
                httppost.setEntity(new StringEntity(jsonObject.toString()));
                response = httpclient.execute(httppost);
            }

            if (response.getStatusLine().getStatusCode()== HttpsURLConnection.HTTP_OK){
                jsonResult = inputStreamToString(response.getEntity().getContent()).toString();
            } else {
                jsonResult += "Error: statuscode " + response.getStatusLine().getStatusCode();
            }
            //JSONObject jsonObject = new JSONObject(jsonResult);
        } catch (Exception e) {
            jsonResult += "Error: doInBackground " + e.toString();
        }
        return jsonResult;
    }

    private StringBuilder inputStreamToString(InputStream is) {
        String rLine = "";
        StringBuilder answer = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));

        try {
            while ((rLine = rd.readLine()) != null) {
                answer.append(rLine);
            }
        } catch (Exception e) {
            //jsonResult = "Error: inputStreamToString " + e.toString();
        }
        return answer;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);

        if(response.toString().contains("Error")) {
            listener.onError(response);
        } else {
            listener.onSuccess(response);
        }
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public interface Listener {
        void onSuccess(String jsonString);
        void onError(String errorMessage);
    }
}