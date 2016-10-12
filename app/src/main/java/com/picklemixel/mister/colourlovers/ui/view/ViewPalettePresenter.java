package com.picklemixel.mister.colourlovers.ui.view;

import android.content.Context;
import android.util.Log;

import com.picklemixel.mister.colourlovers.ui.base.BasePresenter;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 12/10/2016.
 */

class ViewPalettePresenter extends BasePresenter implements IViewPalettePresenter {

    private IViewPaletteView view;
    private Context context;
    private ViewPaletteModel model;

    ViewPalettePresenter(Context context, IViewPaletteView view) {
        this.context = context;
        this.view = view;
        model = new ViewPaletteModel(context, this);
    }

    @Override
    protected void outputData(int error) {
//        view.hideProgress();
        if (error == NO_ERROR) {
            //TODO Output data
            Log.d("NAME", model.getPalette().getTitle());
        } else {
            view.showMessage(error);
        }
    }

    @Override
    public void requestPalette(int paletteId) {
//        view.showProgress();
        model.requestPalette(paletteId);
    }
}
