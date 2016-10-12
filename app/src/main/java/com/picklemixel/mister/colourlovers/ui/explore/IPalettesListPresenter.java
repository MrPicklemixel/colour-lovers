package com.picklemixel.mister.colourlovers.ui.explore;

import com.picklemixel.mister.colourlovers.ui.base.IBasePresenter;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 16/06/16.
 */
public interface IPalettesListPresenter extends IBasePresenter {
    void OnListItemClicked(int id);
    void requestPalettes(String type);
}
