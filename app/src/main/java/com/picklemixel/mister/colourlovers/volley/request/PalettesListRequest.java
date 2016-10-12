package com.picklemixel.mister.colourlovers.volley.request;

import android.content.Context;

import com.android.volley.Request;
import com.picklemixel.mister.colourlovers.model.Palette;
import com.picklemixel.mister.colourlovers.volley.GsonRequest;

import static com.picklemixel.mister.colourlovers.volley.VolleyController.getVolleySingleton;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 25/08/16.
 */
public class PalettesListRequest extends GsonRequest<String, Palette[]> {

    private static final String REQUEST_PATH = "palettes/%1$s?showPaletteWidths=1&format=json";
    private static final int REQUEST_METHOD = Request.Method.GET;

    private PalettesListRequest(Context context, String type, Listener<Palette[]> listener) {
        super(Palette[].class,
                REQUEST_METHOD,
                String.format(REQUEST_PATH, type),
                null,
                context,
                listener);
    }

    public static void submit(Context context, String type, Listener<Palette[]> listener) {
        PalettesListRequest request = new PalettesListRequest(context, type, listener);
        getVolleySingleton().addRequest(request);
    }
}
