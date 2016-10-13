package com.picklemixel.mister.colourlovers.ui.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.picklemixel.mister.colourlovers.R;
import com.picklemixel.mister.colourlovers.model.Palette;
import com.picklemixel.mister.colourlovers.ui.base.BaseActivity;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPaletteActivity extends BaseActivity implements IViewPaletteView{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerViewColours;

    @BindView(R.id.text_view_username_date)
    TextView textViewUsernameAndDate;

    @BindView(R.id.text_view_views)
    TextView textViewViewCount;

    @BindView(R.id.text_view_comments)
    TextView textViewCommentsCount;

    @BindView(R.id.text_view_loves)
    TextView textViewLovesCount;

    @BindView(R.id.text_view_desc)
    TextView textViewDescription;

    private int paletteId;
    private IViewPalettePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View layout = initialiseView();
        setContentView(layout);
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

    @Override
    public void populateColoursList(Palette palette) {
        ColourListAdapter adapter = new ColourListAdapter(getApplicationContext(), palette);
        recyclerViewColours.setAdapter(adapter);
    }

    @Override
    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void setViewCounter(String numViews) {
        textViewViewCount.setText(numViews);
    }

    @Override
    public void setLoveCounter(String numHearts) {
        textViewLovesCount.setText(numHearts);
    }

    @Override
    public void setCommentCounter(String numComments) {
        textViewCommentsCount.setText(numComments);
    }

    @Override
    public void setDescription(String description) {
        textViewDescription.setText(Html.fromHtml(description));
        textViewDescription.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void setUsernameAndDate(String formattedUsernameAndDate) {
        textViewUsernameAndDate.setText(formattedUsernameAndDate);
    }

    private void unpackExtras() {
        paletteId = getIntent().getExtras().getInt(Palette.EXTRA_PALETTE_ID);
    }

    private View initialiseView() {
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_view_palette, null);
        ButterKnife.bind(this, view);
        super.initialiseBaseActivity(view);
        recyclerViewColours.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        return view;
    }
}
