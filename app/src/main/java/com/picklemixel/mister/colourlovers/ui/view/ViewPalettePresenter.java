package com.picklemixel.mister.colourlovers.ui.view;

import android.content.Context;
import android.text.Html;
import android.util.Log;

import com.picklemixel.mister.colourlovers.R;
import com.picklemixel.mister.colourlovers.model.Palette;
import com.picklemixel.mister.colourlovers.ui.base.BasePresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        view.hideProgress();
        if (error == NO_ERROR) {
            Palette palette = model.getPalette();
            view.populateColoursList(palette);
            displayPaletteText(palette);
        } else {
            view.showMessage(error);
        }
    }

    @Override
    public void requestPalette(int paletteId) {
        view.showProgress();
        model.requestPalette(paletteId);
    }

    private void displayPaletteText(Palette palette) {
        view.setTitle(palette.getTitle());
        view.setViewCounter(String.valueOf(palette.getNumViews()));
        view.setLoveCounter(String.valueOf(palette.getNumHearts()));
        view.setCommentCounter(String.valueOf(palette.getNumComments()));

        String description = !palette.getDescription().equals("") ?
                palette.getDescription().replace("\n", "<br>")
                :
                context.getString(R.string.no_description);
        view.setDescription(description);

        String formattedDate = formateDate(palette.getDateCreated());
        String formattedUsernameAndDate = String.format(context.getString(R.string.format_name_and_date), palette.getUserName(), formattedDate);
        view.setUsernameAndDate(formattedUsernameAndDate);
    }

    private String formateDate(String date) {
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat oldFormat = new SimpleDateFormat(context.getString(R.string.format_api_date));
            calendar.setTime(oldFormat.parse(date));
            SimpleDateFormat newFormat = new SimpleDateFormat(context.getString(R.string.format_date));
            return newFormat.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
