package com.picklemixel.mister.colourlovers.viewholder;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.picklemixel.mister.colourlovers.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 11/10/2016.
 */

public class ColourViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.root_layout)
    RelativeLayout mainLayout;

    @BindView(R.id.text_view_hex)
    TextView textViewHex;

    public ColourViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setBackground(String hexColour) {
        mainLayout.setBackgroundColor(Color.parseColor(hexColour));
    }

    public void setHexText(String hexColour) {
        textViewHex.setText(hexColour);
    }
}