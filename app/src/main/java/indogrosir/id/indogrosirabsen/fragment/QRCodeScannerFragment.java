package indogrosir.id.indogrosirabsen.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import indogrosir.id.indogrosirabsen.R;
import indogrosir.id.indogrosirabsen.activity.ScannerActivity;
import indogrosir.id.indogrosirabsen.base.BaseFragment;


public class QRCodeScannerFragment extends BaseFragment {

    @BindView(R.id.open_comera_btn) Button cameraBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myFragment = inflater.inflate(R.layout.fragment_scanner, container, false);
        ButterKnife.bind(this, myFragment);

        cameraBtn.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), ScannerActivity.class));
            getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        });

        return myFragment;
    }

}

