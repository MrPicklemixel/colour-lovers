package com.picklemixel.mister.colourlovers.ui.base;

public abstract class BasePresenter implements IBasePresenter{

    private boolean isDataReady;
    private boolean isViewReady;
    private int lastError;

    @Override
    public void onDataReady() {
        lastError = 0;
        isDataReady = true;
        if (isViewReady) {
            outputData(0);
        }
    }

    @Override
    public void onViewReady() {
        isViewReady = true;
        if (isDataReady) {
            outputData(lastError);
        }
    }

    @Override
    public void onDataError(int error) {
        this.lastError = error;
        isDataReady = true;
        if (isViewReady) {
            outputData(lastError);
        }
    }


    @Override
    public void reset() {
        isDataReady = false;
        isViewReady = false;
        lastError = 0;
    }

    protected abstract void outputData(int error);

}
