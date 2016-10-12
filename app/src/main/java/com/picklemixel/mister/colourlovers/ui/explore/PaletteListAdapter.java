package com.picklemixel.mister.colourlovers.ui.explore;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.picklemixel.mister.colourlovers.R;
import com.picklemixel.mister.colourlovers.model.Palette;
import com.picklemixel.mister.colourlovers.viewholder.PaletteViewHolder;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 16/06/16.
 */
public class PaletteListAdapter extends RecyclerView.Adapter<PaletteViewHolder> {

    Context context;
    Palette[] data;
    LayoutInflater inflater;

    public PaletteListAdapter(Context context, Palette[] data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public PaletteViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = inflater.inflate(R.layout.palette_list_item, parent, false);

        PaletteViewHolder holder = new PaletteViewHolder(view, context, data);

        return holder;
    }

    @Override
    public void onBindViewHolder(PaletteViewHolder holder, int position) {
        holder.resetView();
        Palette palette = data[position];
        holder.setPaletteText(palette);
        holder.createPaletteColours(palette);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

}