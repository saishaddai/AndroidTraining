package com.saishaddai.loginwithretrofit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.saishaddai.loginwithretrofit.api.Api;
import com.saishaddai.loginwithretrofit.model.LoginRequest;
import com.saishaddai.loginwithretrofit.model.LoginResponse;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {

    Button click;
    EditText username;
    EditText password;
    ProgressBar pbar;
    String API = "http://demo6655573.mockable.io/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.send_button);
        username = (EditText) findViewById(R.id.login_edit_text);
        password = (EditText) findViewById(R.id.password_edit_text);
        pbar = (ProgressBar) findViewById(R.id.pb);
        pbar.setVisibility(View.INVISIBLE);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String passwd = password.getText().toString();
                LoginRequest request = new LoginRequest(user, passwd);
                pbar.setVisibility(View.VISIBLE);
                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint(API).build();
                Api git = restAdapter.create(Api.class);
                git.login(request, new Callback<LoginResponse>() {
                    @Override
                    public void success(LoginResponse loginResponse, Response response) {
                        String resultText = "Token :" + loginResponse.getToken() ;
                        Toast.makeText(getApplicationContext(), resultText, Toast.LENGTH_SHORT).show();
                        pbar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        error.printStackTrace();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        pbar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
    }


}
