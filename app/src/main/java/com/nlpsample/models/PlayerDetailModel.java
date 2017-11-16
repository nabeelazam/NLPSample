package com.nlpsample.models;

import com.nlpsample.api.CustomParser;

public class PlayerDetailModel {

    private static PlayerDetailModel _obj;
    public Player player = new Player();

    public PlayerDetailModel() {
    }

    public static PlayerDetailModel getInstance() {
        if (_obj == null)
            _obj = new PlayerDetailModel();
        return _obj;
    }

    public void setList(Object obj) {
        player = (Player) CustomParser.getInstance().getObjectModel(obj, player);
    }


    public boolean isValidData(){
        return (getInstance() != null && getInstance().player != null);
    }
}

