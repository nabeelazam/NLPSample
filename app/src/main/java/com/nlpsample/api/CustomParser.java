package com.nlpsample.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nlpsample.models.NFLMatch;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CustomParser {

    private static CustomParser gsonParser;
    public static CustomParser getInstance() {
        if (gsonParser == null) {
            gsonParser = new CustomParser();
        }
        return gsonParser;
    }

    private static final GsonBuilder builder = new GsonBuilder();
    private static Gson gson;

    public CustomParser() {
        builder.setPrettyPrinting();
        builder.serializeNulls();
        gson = builder.create();
        gson.htmlSafe();
        gson.fieldNamingStrategy();
    }

    /**
     * Function calls gson to convert response string to object
     * @param response
     * @param model
     * @return
     */
    public Object getObjectModel(Object response, Object model) {
        Object dataObj = gson.fromJson(response.toString(), model.getClass());
        return dataObj;
    }


    /**
     * Function converts response string to array of objects
     * using gson
     * @param response
     * @return
     */
    public Object getArrayModel(Object response) {
        Type type = new TypeToken<ArrayList<NFLMatch>>(){}.getType();
        Object dataObj = gson.fromJson(response.toString(), type);
        return dataObj;
    }

}
