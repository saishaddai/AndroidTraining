package com.saishaddai.loginwithokhttp;

import android.app.Activity;
import android.os.StrictMode;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.saishaddai.loginwithokhttp.model.LoginUser;
import com.saishaddai.loginwithokhttp.network.LoginRemoteService;


public class MainActivity extends Activity {

    EditText usernameField;
    EditText passwordField;
    LoginRemoteService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setStrictModePolicyIfNeeded();
        usernameField = (EditText) findViewById(R.id.login_edit_text);
        passwordField = (EditText) findViewById(R.id.password_edit_text);
        loginService = new LoginRemoteService();
    }

    private void setStrictModePolicyIfNeeded() {
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.
                    Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }


    public void sendLoginMessage(View view) {
        LoginUser loginUser = getLoginUserFromFields();
        callLoginService(loginUser);
        Toast.makeText(this, R.string.warning_well_done, Toast.LENGTH_SHORT). show();
    }

    private void callLoginService(LoginUser loginUser) {
        try {
            loginService.login(loginUser);
        } catch (Exception e) {
            Toast.makeText(this, R.string.error_service_unreachable, Toast.LENGTH_SHORT).show();
        }
    }

    private LoginUser getLoginUserFromFields() {
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        return new LoginUser(username, password);
    }
}
