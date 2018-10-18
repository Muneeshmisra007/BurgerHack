package com.burgerhack.core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.recommended.core.R;


/**
 * Created by Amritpal Singh on 19/10/18.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = BaseFragment.class.getSimpleName();
    private final int requestCode = 0;

    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        ViewGroup subFragmentViewContainer = view.findViewById(R.id.subFragmentViewContainer);
        View subFragmentView = inflater.inflate(getFragmentLayoutId(), subFragmentViewContainer, false);
        subFragmentViewContainer.removeAllViews();
        subFragmentViewContainer.addView(subFragmentView);

//        Button btnRetry = view.findViewById(R.id.btnRetry);
//        btnRetry.setOnClickListener(this);
//        Button btnSettings = view.findViewById(R.id.btnSettings);
//        btnSettings.setOnClickListener(this);

        return view;
    }

    protected abstract int getFragmentLayoutId();

    protected abstract int getContainerViewGroupId();

    protected void showStatus(STATUS status, String statusText) {
        if (getView() == null) {
            return;
        }

        View rootView = getView();
        ProgressBar progressBar = rootView.findViewById(R.id.pbBaseFragmentProgress);
        View fragmentContentView = rootView.findViewById(getContainerViewGroupId());
        View errorDisplayNetworkContainer = rootView.findViewById(R.id.containerErrorDisplay).findViewById(R.id.containerErrorDisplay);

        switch (status) {
            case STATUS_LOADING:
                progressBar.setVisibility(View.VISIBLE);
                fragmentContentView.setVisibility(View.GONE);
                errorDisplayNetworkContainer.setVisibility(View.GONE);
                break;

            case STATUS_SUCCESS:
                progressBar.setVisibility(View.GONE);
                fragmentContentView.setVisibility(View.VISIBLE);
                errorDisplayNetworkContainer.setVisibility(View.GONE);
                break;

            case STATUS_ERROR:
                progressBar.setVisibility(View.GONE);
                fragmentContentView.setVisibility(View.GONE);
                errorDisplayNetworkContainer.setVisibility(View.VISIBLE);
                break;

            case STATUS_NETWORK_ERROR:
                progressBar.setVisibility(View.GONE);
                fragmentContentView.setVisibility(View.GONE);
                errorDisplayNetworkContainer.setVisibility(View.VISIBLE);
                break;

            case STATUS_EMPTY://Specialised case of Error in Watchlist/download cases where the content is Empty.
                progressBar.setVisibility(View.GONE);
                fragmentContentView.setVisibility(View.GONE);
                errorDisplayNetworkContainer.setVisibility(View.GONE);
                break;
        }
    }

    protected void showStatus(STATUS status, int stringResourceId) {
        //showStatus(status, stringResourceId == 0 ? null : getString(stringResourceId));
    }

    protected void showStatus(STATUS status) {
        showStatus(status, 0);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnRetry) {
            refreshActiveFragment();
        } else if (id == R.id.btnSettings) {
            startActivityForResult(new Intent(Settings.ACTION_WIFI_SETTINGS), requestCode);
        }
    }

    protected abstract void refreshActiveFragment();

    public enum STATUS {
        STATUS_LOADING, STATUS_SUCCESS, STATUS_ERROR, STATUS_EMPTY, STATUS_NETWORK_ERROR
    }

}