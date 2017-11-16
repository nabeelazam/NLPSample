package com.nlpsample.models;

import java.util.ArrayList;

public class NFLMatchModel {

    private static NFLMatchModel _obj;
    public ArrayList<NFLMatch> response = new ArrayList<>();

    public NFLMatchModel() {
    }

    public static NFLMatchModel getInstance() {
        if (_obj == null)
            _obj = new NFLMatchModel();
        return _obj;
    }

    public void setList(Object obj) {
        response = (ArrayList<NFLMatch>)obj;
    }
}
