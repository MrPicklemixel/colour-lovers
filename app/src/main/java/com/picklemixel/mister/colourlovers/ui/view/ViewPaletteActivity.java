package com.picklemixel.mister.colourlovers.ui.view;

import android.os.Bundle;

import com.picklemixel.mister.colourlovers.R;
import com.picklemixel.mister.colourlovers.model.Palette;
import com.picklemixel.mister.colourlovers.ui.base.BaseActivity;

public class ViewPaletteActivity extends BaseActivity implements IViewPaletteView{

    private int paletteId;
    private IViewPalettePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_palette);
        unpackExtras();
        presenter = new ViewPalettePresenter(getApplicationContext(), this);
        presenter.requestPalette(paletteId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onViewReady();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.reset();
    }

    private void unpackExtras() {
        paletteId = getIntent().getExtras().getInt(Palette.EXTRA_PALETTE_ID);
    }
}
