package com.saishaddai.loginwithokhttp.network;

import android.util.Log;
import com.google.gson.Gson;
import com.saishaddai.loginwithokhttp.model.LoginUser;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;


import java.io.IOException;

public class LoginRemoteService {

    private static final String TAG = LoginRemoteService.class.getName();
    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient client = new OkHttpClient();
    private String URL = "http://demo6655573.mockable.io/"; //Just an example
    Gson gson = new Gson();

    public String login(LoginUser loginUser) throws Exception {
        String response = "";
        boolean isValidateLoginValues =
                validateLoginInfo(loginUser);
        if(isValidateLoginValues) {
            response = post(URL, gson.toJson(loginUser));
        }
        return response;
    }

    private String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = null;
        try {
             response = client.newCall(request).execute();
        } catch(Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }
        return response.body().string();
    }

    private boolean validateLoginInfo(LoginUser loginUser) {
        return loginUser != null && !loginUser.getUsername().isEmpty() && !loginUser.getPassword().isEmpty() ;
    }

}


