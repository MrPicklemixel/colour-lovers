package com.picklemixel.mister.colourlovers.volley;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.picklemixel.mister.colourlovers.application.ColourLoversApplication;

public class VolleyController {

    private static VolleyController instance = null;

    public RequestQueue requestQueue;

    private VolleyController() {
        requestQueue = Volley.newRequestQueue(ColourLoversApplication.applicationContext);
    }

    public static VolleyController getVolleySingleton() {
        if (instance == null) {
            instance = new VolleyController();
        }

        return instance;
    }

    public <T> void addRequest(Request<T> request) {
        requestQueue.add(request);
    }
}
