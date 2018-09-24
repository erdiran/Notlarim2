package notlarim.erdioran.com.notlarim;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class AsyncTaskUse extends Activity{

    /**

    TextView textViewUyduBilgileri;


    public String API_URL= Utils.API_URL;
    protected static final String DATA="data";
    protected static final String UYDUBILGI="uyduBilgileri";
    protected static final String RESPONSE="Response";
    public static final String TITLE="Title";
    public static final String DESCRIPTION="Description";
    public static final String SPOT="Spot";

    public String TITLE_BILGI,DESC_BILGI,SPOR_BILGI;

    JSONObject jsonObject, jsonObjectData, jsonObjectUyduBilgi,jsonObjectResponse = null;
    JSONParseObject jsonObjectWriter = new JSONParseObject();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uydu_bilgileri);

        new JsonParsing().execute();
        textViewUyduBilgileri = (TextView) findViewById(R.id.uydu_bilgileri);




    }


    private class JsonParsing extends AsyncTask<String, Integer, ArrayList<HashMap<String, String>>> {

        ArrayList<HashMap<String, String>> uyduList = new ArrayList<HashMap<String, String>>();
        @Override
        protected ArrayList<HashMap<String, String>>  doInBackground(String... strings) {

            jsonObject = jsonObjectWriter.makeHttpRequest(API_URL);
            try {
                jsonObject = jsonObject.getJSONObject(DATA);
                jsonObjectUyduBilgi = jsonObject.getJSONObject(UYDUBILGI);
                jsonObjectResponse = jsonObjectUyduBilgi.getJSONObject(RESPONSE);
                TITLE_BILGI = jsonObjectResponse.getString(TITLE);
                DESC_BILGI = jsonObjectResponse.getString(DESCRIPTION);
                SPOR_BILGI = jsonObjectResponse.getString(SPOT);


            } catch (JSONException e) {
                e.printStackTrace();
            }
            return uyduList;
        }

        @Override
        protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
            super.onPostExecute(result);

            textViewUyduBilgileri.setText(Html.fromHtml(DESC_BILGI));


        }


    }
    **/
}
