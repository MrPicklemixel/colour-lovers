package com.picklemixel.mister.colourlovers.ui.explore;

import android.content.Context;

import com.android.volley.VolleyError;
import com.picklemixel.mister.colourlovers.R;
import com.picklemixel.mister.colourlovers.model.Palette;
import com.picklemixel.mister.colourlovers.volley.GsonRequest;
import com.picklemixel.mister.colourlovers.volley.request.PalettesListRequest;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 16/06/16.
 */
public class PalettesListModel {

    private IPalettesListPresenter presenter;
    private Context context;
    private Palette[] palettes;

    private GsonRequest.Listener<Palette[]> callback = new GsonRequest.Listener<Palette[]>() {
        @Override
        public void onSuccess(Palette[] response) {
            palettes = response;
            presenter.onDataReady();
        }

        @Override
        public void onError(VolleyError error) {
            presenter.onDataError(R.string.request_error);
        }
    };

    PalettesListModel(IPalettesListPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    public void requestPalettes(String type) {
        PalettesListRequest.submit(context, type, callback);
    }

    public Palette[] getPalettes() {
        return palettes;
    }

}
