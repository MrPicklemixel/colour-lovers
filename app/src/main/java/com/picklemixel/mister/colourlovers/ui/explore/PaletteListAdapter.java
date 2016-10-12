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
class PaletteListAdapter extends RecyclerView.Adapter<PaletteViewHolder> {

    private IPalettesListPresenter presenter;
    private Context context;
    private Palette[] palettes;
    private LayoutInflater inflater;

    PaletteListAdapter(Context context, IPalettesListPresenter presenter, Palette[] palettes) {
        this.context = context;
        this.presenter = presenter;
        this.palettes = palettes;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public PaletteViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = inflater.inflate(R.layout.palette_list_item, parent, false);

        PaletteViewHolder holder = new PaletteViewHolder(view, context, palettes);

        return holder;
    }

    @Override
    public void onBindViewHolder(PaletteViewHolder holder, int position) {
        holder.resetView();
        final Palette palette = palettes[position];
        holder.setPaletteText(palette);
        holder.createPaletteColours(palette);
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.OnListItemClicked(palette.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return palettes.length;
    }

}