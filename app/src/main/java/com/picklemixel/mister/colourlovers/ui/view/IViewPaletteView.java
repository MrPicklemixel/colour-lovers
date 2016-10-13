package com.picklemixel.mister.colourlovers.ui.view;

import com.picklemixel.mister.colourlovers.model.Palette;
import com.picklemixel.mister.colourlovers.ui.base.IBaseView;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 12/10/2016.
 */

interface IViewPaletteView extends IBaseView {

    void populateColoursList(Palette palette);

    void setTitle(String title);

    void setViewCounter(String numViews);

    void setLoveCounter(String numHearts);

    void setCommentCounter(String numComments);

    void setDescription(String description);

    void setUsernameAndDate(String formattedUsernameAndDate);
}
