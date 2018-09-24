package notlarim.erdioran.com.notlarim;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class JSONParseObject {
    static JSONObject jsonObject = null;
    static String jsonLine = "";

    public JSONObject makeHttpRequest(String v){
        try {
            URL url = new URL(v);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            try {
                while((line = reader.readLine()) != null){
                    stringBuilder.append(line + "\n");
                    Log.d("jsonLine", line);
                }//end of while
                jsonLine = stringBuilder.toString();
                try {
                    jsonObject = new JSONObject(jsonLine);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }//end of 3 try-catch
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }//end of 2 try-catch
        } catch (Exception e){
            e.printStackTrace();
        }//end of 1 try-catch

        return jsonObject;
    }//end of JSONObject
}//end of JSONParseObject