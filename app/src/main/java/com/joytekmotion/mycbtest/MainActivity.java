package com.joytekmotion.mycbtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.GridView;
import com.joytekmotion.mycbtest.JSONReader;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare jsonReader object to get read our json from file
        JSONReader jsonReader = new JSONReader(R.raw.homebuttons, MainActivity.this);

        try {
            //get JSON object from file
            JSONObject homeButtonsConfig = new JSONObject(jsonReader.toString());

            //get button icon id into homeBtn array from JSON
            int[] homeBtn = new int[homeButtonsConfig.length()];
            for(int i = 0; i < homeButtonsConfig.length(); i++) {
                // get icon name from JSON
                String iconName = homeButtonsConfig.getString("" + i + "");
                // get resource id
                int resID = getResources().getIdentifier(iconName, "drawable", getPackageName());
                // place resource ids in array
                homeBtn[i] = resID;
            }

            // Display buttons on grid view
            GridView gridView = (GridView) findViewById(R.id.gridView);
            // Define gridView adapter
            gridView.setAdapter(new GridAdapter(MainActivity.this, homeBtn));



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
