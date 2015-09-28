package com.saishaddai.testwithmockito;

import junit.framework.TestCase;

import org.json.JSONObject;

public class AnyClassTest extends TestCase {

    public void testGetJSONVorgees() throws Exception {
        AnyClass anyClass = new AnyClass();
        JSONObject jsonObject = anyClass.getJSONVorgees("name");
        assertNotNull(jsonObject);
    }

    public void testGetJSONVorgeesWithNull() throws Exception {
        JSONObject jsonObject = null;
        try {
            AnyClass anyClass = new AnyClass();
             jsonObject = anyClass.getJSONVorgees(null);
        } catch(Exception e) {
            assertNull(jsonObject);
        }
    }
}