package com.matt2393.recyclerviewejemplojava;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by matt on 06-10-17.
 */
public final class VolleyQueue {
    private static VolleyQueue volleyQueue;
    private RequestQueue cola;
    private static Context context;

    private VolleyQueue(Context context) {
        VolleyQueue.context = context;
        cola = getCola();
    }

    public static synchronized VolleyQueue getInstance(Context context) {
        if (volleyQueue == null)
            volleyQueue = new VolleyQueue(context);

        return volleyQueue;
    }

    private RequestQueue getCola() {
        if (cola == null) {
            cola = Volley.newRequestQueue(context.getApplicationContext());
        }

        return cola;
    }

    public void addColaRequest(Request request) {
        getCola().add(request);
    }
}
