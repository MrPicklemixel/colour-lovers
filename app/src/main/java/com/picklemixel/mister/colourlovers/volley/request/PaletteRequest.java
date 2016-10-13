package com.picklemixel.mister.colourlovers.volley.request;

import android.content.Context;

import com.picklemixel.mister.colourlovers.model.Palette;
import com.picklemixel.mister.colourlovers.volley.GsonRequest;

import static com.picklemixel.mister.colourlovers.volley.VolleyController.getVolleySingleton;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 25/08/16.
 */
public class PaletteRequest extends GsonRequest<String, Palette[]> {

    private static final String REQUEST_PATH = "palette/%1$s?showPaletteWidths=1&format=json";
    private static final int REQUEST_METHOD = Method.GET;

    private PaletteRequest(Context context, String paletteId, Listener<Palette[]> listener) {
        super(Palette[].class,
                REQUEST_METHOD,
                String.format(REQUEST_PATH, paletteId),
                null,
                context,
                listener);
    }

    public static void submit(Context context, int paletteId, Listener<Palette[]> listener) {
        PaletteRequest request = new PaletteRequest(context, String.valueOf(paletteId), listener);
        getVolleySingleton().addRequest(request);
    }
}
