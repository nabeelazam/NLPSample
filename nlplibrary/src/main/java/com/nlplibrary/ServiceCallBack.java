package com.nlplibrary;

import com.nlplibrary.utils.Logger;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ServiceCallBack {
    Object caller;
    String method;

    public ServiceCallBack(Object callie, String name) {
        this.caller = callie;
        this.method = name;
    }

    public void invoke(Object obj) {

        Method method;
        ArrayList<Class> partTypes = new ArrayList<>();
        partTypes.add(Object.class);
        partTypes.add(Object.class);

        ArrayList<Object> args = new ArrayList<>();
        args.add(caller);
        args.add(obj);
        try {
            method = caller.getClass().getMethod(this.method, partTypes.toArray(new Class[partTypes.size()]));
            method.invoke(caller, args.toArray(new Object[args.size()]));
            // clear the data array which used before
            partTypes.clear();
            args.clear();
        } catch (Exception e) {
            Logger.logException(e);
        }
        destroyData();
    }

    private void destroyData() {
        caller = null;
        method = null;
    }
}
