package indogrosir.id.indogrosirabsen.activity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import indogrosir.id.indogrosirabsen.R;
import indogrosir.id.indogrosirabsen.base.BaseActivity;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.link_login) TextView linkLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        linkLogin.setOnClickListener(v -> {
            openNewActivity(LoginActivity.class);
        });
    }
}
