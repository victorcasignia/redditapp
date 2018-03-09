package com.example.p004.redditapiconnection;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by P004 on 3/9/2018.
 */

public class ApiConnector {
    private RequestQueue queue;
    private CurrentResponse CurrentResponse;
    public ApiConnector(RequestQueue queue, CurrentResponse cr){
        this.queue = queue;
        CurrentResponse = cr;
    }
    public void RequestGet(String Address){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Address,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            CurrentResponse.setResponse(new JSONObject(response));
                        }
                        catch(JSONException e){
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.print(error.toString());
            }
        });
        this.queue.add(stringRequest);
    }

    public void RequestPost(String Address, final Map<String, String> Params){
        StringRequest postRequest = new StringRequest(Request.Method.POST, Address,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = Params;
                return params;
            }
        };
        queue.add(postRequest);
    }
}

