package indogrosir.id.indogrosirabsen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import indogrosir.id.indogrosirabsen.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_btn) Button loginBtn;
    @BindView(R.id.input_email) EditText emailEdt;
    @BindView(R.id.input_password) EditText passwordEdt;
    @BindView(R.id.link_signup) TextView signupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginBtn.setOnClickListener(v -> login());
//        signupLink.setOnClickListener(view -> { openNewActivity(SignupActivity.class); });
    }

    public void login() {

        if (!validate()) {
            onLoginFailed();
            return;
        }

        loginBtn.setEnabled(false);

        String email = emailEdt.getText().toString();
        String password = passwordEdt.getText().toString();

        new android.os.Handler().postDelayed(
                () -> {
                    // On complete call either onLoginSuccess or onLoginFailed
                    onLoginSuccess();
                }, 3000);
    }

    public boolean validate() {
        boolean valid = true;

        String email = emailEdt.getText().toString();
        String password = passwordEdt.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEdt.setError("enter a valid email address");
            valid = false;
        } else {
            emailEdt.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            passwordEdt.setError("password must be more than 6 character");
            valid = false;
        } else {
            passwordEdt.setError(null);
        }

        return valid;
    }

    public void onLoginSuccess() {
        loginBtn.setEnabled(true);
        openNewActivity(MainActivity.class);
    }

    public void onLoginFailed() {
        loginBtn.setEnabled(true);
    }

}
