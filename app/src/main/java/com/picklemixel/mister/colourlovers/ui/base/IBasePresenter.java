package com.picklemixel.mister.colourlovers.ui.base;

public interface IBasePresenter {

    void onViewReady();
    void onDataReady();
    void onDataError(int error);
    void reset();
}
