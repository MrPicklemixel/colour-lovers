package com.picklemixel.mister.colourlovers.ui.explore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.picklemixel.mister.colourlovers.R;
import com.picklemixel.mister.colourlovers.model.Palette;
import com.picklemixel.mister.colourlovers.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PalettesListFragment extends BaseFragment implements IPalettesListView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    IPalettesListPresenter presenter;
    PaletteListAdapter adapter;

    public static final String TYPE_NEW = "new";
    public static final String TYPE_TOP = "top";
    private static final String KEY_TYPE = "type";

    private String fragmentType;

    public static PalettesListFragment newInstance(String type) {
        PalettesListFragment fragment = new PalettesListFragment();

        Bundle args = new Bundle();
        args.putString(KEY_TYPE, type);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceBundle) {
        super.onCreateView(inflater, container, savedInstanceBundle);
        View view = initialiseView(inflater, container);
        initialiseArgs();
        presenter = new PalettesListPresenter(this, getContext());
        presenter.requestPalettes(fragmentType);
        return view;
    }

    private void initialiseArgs() {
        fragmentType = getArguments().getString(KEY_TYPE);
    }

    private View initialiseView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_palette_list, container, false);
        ButterKnife.bind(this, view);
        super.initialiseBaseFragment(view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onViewReady();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.reset();
    }

    @Override
    public void onListItemClicked(int id) {
        presenter.OnListItemClicked(id);
    }

    @Override
    public void populateList(Palette[] data) {
        adapter = new PaletteListAdapter(getContext(), data);
        recyclerView.setAdapter(adapter);
    }
}
