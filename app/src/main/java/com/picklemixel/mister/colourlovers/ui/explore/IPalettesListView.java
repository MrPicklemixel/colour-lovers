package com.picklemixel.mister.colourlovers.ui.explore;

import com.picklemixel.mister.colourlovers.model.Palette;
import com.picklemixel.mister.colourlovers.ui.base.IBaseView;

import java.util.ArrayList;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 16/06/16.
 */
public interface IPalettesListView extends IBaseView {
    void onListItemClicked(int id);
    void populateList(Palette[] data);
}
