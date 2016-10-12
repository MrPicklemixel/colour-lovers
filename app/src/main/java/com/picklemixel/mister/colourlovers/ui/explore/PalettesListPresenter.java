package com.picklemixel.mister.colourlovers.ui.explore;

import android.content.Context;

import com.picklemixel.mister.colourlovers.ui.base.BasePresenter;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 16/06/16.
 */
class PalettesListPresenter extends BasePresenter implements IPalettesListPresenter {

    private PalettesListModel model;
    private IPalettesListView view;

    PalettesListPresenter(IPalettesListView view, Context context) {
        super();
        model = new PalettesListModel(this, context);
        this.view = view;
    }

    @Override
    public void OnListItemClicked(int id) {
        //TODO open next activity
    }

    @Override
    public void requestPalettes(String type) {
        model.requestPalettes(type);
    }

    @Override
    protected void outputData(int error) {
        view.hideProgress();
        if (error == 0) {
            view.populateList(model.getPalettes());
        } else {
            view.showMessage(error);
        }
    }

}
