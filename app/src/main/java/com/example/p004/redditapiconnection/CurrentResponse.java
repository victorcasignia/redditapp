package com.example.p004.redditapiconnection;

import org.json.JSONObject;

/**
 * Created by P004 on 3/9/2018.
 */

public class CurrentResponse {
    private JSONObject Response;
    private ChangeListener listener;

    public CurrentResponse(){
        Response = new JSONObject();
    }

    public JSONObject GetResponse() {
        return Response;
    }

    public void setResponse(JSONObject Response) {
        this.Response = Response;
        if (listener != null) listener.onChange();
    }

    public ChangeListener getListener() {
        return listener;
    }

    public void setListener(ChangeListener listener) {
        this.listener = listener;
    }

    public interface ChangeListener {
        void onChange();
    }
}
