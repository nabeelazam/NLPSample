package com.nlplibrary.utils;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;


public class Logger {

    private static boolean DEBUG = true;

    /**
     * @param msg
     */
    public static void log(Object msg) {
        if (DEBUG) {
            Log.e("NLP: >", "" + msg.toString());
        }
    }

    /**
     * print the stack on exception raise.
     *
     * @param exception
     */
    public static void logException(Exception exception) {
        if (DEBUG) {
            try {
                Writer writer = new StringWriter();
                exception.printStackTrace(new PrintWriter(writer));
                Log.e("NLP: >Exception::", "" + writer.toString());
                exception.printStackTrace();
            } catch (Exception ignore) {
                Logger.log("Exception print error");
            }

        }
    }
}
