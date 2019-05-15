package com.joytekmotion.mycbtest;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;

/* This class reads the JSON file and extracts its content for the button */
public class JSONReader {

    int JSONPath;
    Context context;

    public JSONReader(int JSONPath, Context context) {
        this.JSONPath = JSONPath;
        this.context = context;
    }

    // returns JSON Objects Array
    public String toString() {
        String json = null;
        try {
            // Declare inputstream to read json file
            InputStream inputStream = context.getResources().openRawResource(JSONPath);

            int size = inputStream.available();

            // Declare buffer to read input stream into
            byte[] buffer = new byte[size];

            // read inputstream into buffer
            inputStream.read(buffer);

            // close inputstream
            inputStream.close();

            // pass read json into string
            json = new String(buffer, "UTF-8");

        }

        catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }

    // Validate JSON file
    public boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
        }
        catch (JSONException e) {
            try {
                new JSONArray(test);
            }
            catch (JSONException ex) {
                return false;
            }
        } return true;
    }

}
