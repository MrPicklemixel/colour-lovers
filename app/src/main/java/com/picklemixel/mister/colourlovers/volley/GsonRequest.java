package com.picklemixel.mister.colourlovers.volley;

import android.content.Context;
import android.net.Uri;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.picklemixel.mister.colourlovers.BuildConfig;

import java.io.UnsupportedEncodingException;

public abstract class GsonRequest<T1, T2> extends Request<T2> {

    private final String requestPath;
    private final Class<T2> clazz;
    protected final Listener<T2> listener;
    protected final Context context;
    private final T1 requestBody;
    private Gson gson;

    public GsonRequest(Class<T2> clazz, int method, String requestPath, T1 requestBody, Context context, Listener<T2> listener) {
        super(method, null, null);
        this.clazz = clazz;
        this.listener = listener;
        this.requestPath = requestPath;
        this.requestBody = requestBody;
        this.context = context;
        this.gson = new GsonBuilder()
                .create();
    }

    @Override
    public String getUrl() {
        Uri.Builder builder = new Uri.Builder()
                .scheme(BuildConfig.SERVICES_SCHEME)
                .encodedAuthority(BuildConfig.SERVICES_AUTHORITY)
                .appendEncodedPath(requestPath);

        return builder.build().toString();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        if (requestBody == null) {
            return null;
        }
        String bodyString = gson.toJson(requestBody);
        return bodyString.getBytes();
    }

    @Override
    protected void deliverResponse(T2 response) {
        if (listener != null) {
            listener.onSuccess(response);
        }
    }

    @Override
    public void deliverError(VolleyError error) {
        if (listener != null) {
            listener.onError(error);
        }
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(json, clazz), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    public String getBodyContentType() {
        return "application/json";
    }

    public interface Listener<T> {
        void onSuccess(T response);

        void onError(VolleyError error);
    }
}
