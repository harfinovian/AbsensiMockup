package indogrosir.id.indogrosirabsen.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import indogrosir.id.indogrosirabsen.R;
import indogrosir.id.indogrosirabsen.base.BaseFragment;

public class DashboardFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myFragment = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, myFragment);

        return myFragment;
    }
}
