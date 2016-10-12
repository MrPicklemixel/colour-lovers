package com.picklemixel.mister.colourlovers.ui.view;

import android.content.Context;

import com.android.volley.VolleyError;
import com.picklemixel.mister.colourlovers.R;
import com.picklemixel.mister.colourlovers.model.Palette;
import com.picklemixel.mister.colourlovers.volley.GsonRequest;
import com.picklemixel.mister.colourlovers.volley.request.PaletteRequest;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 12/10/2016.
 */

class ViewPaletteModel {

    private Context context;
    private IViewPalettePresenter presenter;
    private Palette palette;

    private GsonRequest.Listener<Palette[]> callback = new GsonRequest.Listener<Palette[]>() {
        @Override
        public void onSuccess(Palette[] response) {
            palette = response[0];
            presenter.onDataReady();
        }

        @Override
        public void onError(VolleyError error) {
            presenter.onDataError(R.string.request_error);
        }
    };

    ViewPaletteModel(Context context, IViewPalettePresenter presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    void requestPalette(int paletteId) {
        PaletteRequest.submit(context, paletteId, callback);
    }

    public Palette getPalette() {
        return palette;
    }
}
