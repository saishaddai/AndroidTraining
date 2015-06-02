package com.saishaddai.loginwithbasicurlconnection;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.saishaddai.loginwithbasicurlconnection.models.LoginUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends Activity {

    EditText usernameField;
    EditText passwordField;
    String URL_SOURCE = "http://demo6655573.mockable.io/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = (EditText) findViewById(R.id.login_edit_text);
        passwordField = (EditText) findViewById(R.id.password_edit_text);
    }


    public void sendLoginMessage(View view) {
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        LoginUser loginUser = new LoginUser(username, password);

        new MyTask().execute(loginUser);

    }

    private class MyTask extends AsyncTask<LoginUser, Void, Void> {

        String textResult = "";

        @Override
        protected Void doInBackground(LoginUser... loginUsers) {
            URL textUrl;
            try {
                String realURL = URL_SOURCE + "?username=" + loginUsers[0].getUsername()
                        + "&password" + loginUsers[0].getPassword();
                textUrl = new URL(realURL);
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(textUrl.openStream()));
                String stringBuffer;
                String stringText = "";

                while((stringBuffer = bufferedReader.readLine() ) != null) {
                    stringText += stringBuffer;
                }

                bufferedReader.close();
                textResult = stringText;

            } catch (MalformedURLException e ) {
                e.printStackTrace();
                textResult = e.toString();
            } catch (IOException e) {
                e.printStackTrace();
                textResult = e.toString();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Toast.makeText(getApplicationContext(), "yeaaaaah" + textResult, Toast.LENGTH_SHORT).show();
            super.onPostExecute(result);
        }
    }
}
