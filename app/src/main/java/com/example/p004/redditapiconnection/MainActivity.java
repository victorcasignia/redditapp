package com.example.p004.redditapiconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ApiConnector ReddicConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        final CurrentResponse cr = new CurrentResponse();
        ReddicConnect = new ApiConnector(queue, cr);

        cr.setListener(new CurrentResponse.ChangeListener() {
            @Override
            public void onChange() {
                try{
                    List<RedditObject> x = RedditJSONParser.ParseListing(new JSONObject(cr.GetResponse().toString()));
                    System.out.println(x.size());
                }
                catch (JSONException e){
                    System.out.println(e.getMessage());
                }
            };
        });

        ReddicConnect.RequestGet("https://www.reddit.com/.json");
        ReddicConnect.RequestGet("https://www.reddit.com/r/dota2.json");
    }
}
