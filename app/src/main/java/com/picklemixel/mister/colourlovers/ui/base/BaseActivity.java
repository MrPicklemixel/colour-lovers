package com.picklemixel.mister.colourlovers.ui.base;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.picklemixel.mister.colourlovers.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Masterfully pieced together by the Al-Mighty Paul on 11/10/2016.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.root_view)
    View rootView;

    public void initialiseBaseActivity(View layout) {
        ButterKnife.bind(this, layout);
    }

    @Override
    public void showMessage(int id) {
        Snackbar.make(rootView,id,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
