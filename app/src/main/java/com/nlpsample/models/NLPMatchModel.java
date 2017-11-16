package com.nlpsample.models;

import java.util.ArrayList;

public class NLPMatchModel {
    private static NLPMatchModel _obj;

    public NLPMatchModel() {
    }

    public static NLPMatchModel getInstance() {
        if (_obj == null)
            _obj = new NLPMatchModel();
        return _obj;
    }

    public void setList(NLPMatchModel obj) {
        this._obj = obj;
    }

    public ArrayList<NLPMatch> response;
}
