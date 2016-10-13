package com.picklemixel.mister.colourlovers.ui.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.picklemixel.mister.colourlovers.R;
import com.picklemixel.mister.colourlovers.model.Palette;
import com.picklemixel.mister.colourlovers.ui.explore.IPalettesListPresenter;
import com.picklemixel.mister.colourlovers.viewholder.ColourViewHolder;
import com.picklemixel.mister.colourlovers.viewholder.PaletteViewHolder;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 16/06/16.
 */
class ColourListAdapter extends RecyclerView.Adapter<ColourViewHolder> {

    private Context context;
    private Palette palette;
    private LayoutInflater inflater;

    ColourListAdapter(Context context, Palette palette) {
        this.context = context;
        this.palette = palette;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ColourViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = inflater.inflate(R.layout.colour_list_item, parent, false);

        ColourViewHolder holder = new ColourViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ColourViewHolder holder, int position) {
        String colour = palette.getColor(context, position);
        holder.setBackground(colour);
        holder.setHexText(colour);
    }

    @Override
    public int getItemCount() {
        return palette.getColors().size();
    }

}