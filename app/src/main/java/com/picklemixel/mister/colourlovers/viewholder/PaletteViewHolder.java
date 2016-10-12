package com.picklemixel.mister.colourlovers.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.picklemixel.mister.colourlovers.R;
import com.picklemixel.mister.colourlovers.model.Palette;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 11/10/2016.
 */

public class PaletteViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.main)
    LinearLayout mainLayout;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.username)
    TextView username;

    @BindView(R.id.text_view_views)
    TextView views;

    @BindView(R.id.text_view_comments)
    TextView comments;

    @BindView(R.id.text_view_loves)
    TextView loves;

    private Context context;
    private Palette[] palettes;

    public PaletteViewHolder(View itemView, Context context, Palette[] palettes) {
        super(itemView);
        this.context = context;
        this.palettes = palettes;
        ButterKnife.bind(this, itemView);
    }

    @OnClick(R.id.main)
    public void onPaletteClicked() {
        Palette palette = palettes[getAdapterPosition()];
//        ((PalettesListFragment) context).onListItemClicked(palette.getId());
        Toast.makeText(context, "" + palette.getTitle(), Toast.LENGTH_SHORT).show();
    }

    public void resetView() {
        mainLayout.removeAllViews();
    }

    public void setPaletteText(Palette palette) {
        title.setText(palette.getTitle());
        username.setText(palette.getUserName());
        views.setText(String.valueOf(palette.getNumViews()));
        comments.setText(String.valueOf(palette.getNumComments()));
        loves.setText(String.valueOf(palette.getNumHearts()));
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
}