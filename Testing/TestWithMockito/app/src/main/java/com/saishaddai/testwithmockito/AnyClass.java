package com.saishaddai.testwithmockito;

import org.json.JSONException;
import org.json.JSONObject;

public class AnyClass {

    public JSONObject getJSONVorgees(String name) throws JSONException {
        return new JSONObject("{name : " + name + "}");
    }

}
