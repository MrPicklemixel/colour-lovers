package com.picklemixel.mister.colourlovers.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.picklemixel.mister.colourlovers.R;
import com.picklemixel.mister.colourlovers.model.Palette;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 11/10/2016.
 */

public class PaletteViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.root_layout)
    LinearLayout mainLayout;

    @BindView(R.id.text_view_title)
    TextView textViewTitle;

    @BindView(R.id.text_view_username)
    TextView textViewUsername;

    @BindView(R.id.text_view_views)
    TextView textViewViewCount;

    @BindView(R.id.text_view_comments)
    TextView textViewCommentsCount;

    @BindView(R.id.text_view_loves)
    TextView textViewLovesCount;

    private Context context;
    private Palette[] palettes;

    public PaletteViewHolder(View itemView, Context context, Palette[] palettes) {
        super(itemView);
        this.context = context;
        this.palettes = palettes;
        ButterKnife.bind(this, itemView);
    }

    @OnClick(R.id.root_layout)
    public void onPaletteClicked() {
        Palette palette = palettes[getAdapterPosition()];
    }

    public void resetView() {
        mainLayout.removeAllViews();
    }

    public void setPaletteText(Palette palette) {
        textViewTitle.setText(palette.getTitle());
        textViewUsername.setText(palette.getUserName());
        textViewViewCount.setText(String.valueOf(palette.getNumViews()));
        textViewCommentsCount.setText(String.valueOf(palette.getNumComments()));
        textViewLovesCount.setText(String.valueOf(palette.getNumHearts()));
    }

    public void createPaletteColours(Palette palette) {
        for (int i = 0; i < palette.getSize(); i++) {
            LinearLayout layout = new LinearLayout(context);
            layout.setBackgroundColor(Color.parseColor(palette.getColor(context, i)));
            LinearLayout.LayoutParams LLParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    palette.getColorWidth(i));
            layout.setLayoutParams(LLParams);
            mainLayout.addView(layout);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mainLayout.setOnClickListener(onClickListener);
    }
}