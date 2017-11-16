package com.nlplibrary.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

public class NetworkUtil {

    private static Dialog mDialog = null;

    /**
     * Check if internet is available
     *
     * @param context
     * @return
     */
    public static boolean isInternetConnected(Context context) {
        boolean status = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            if (null != activeNetwork) {

                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                    status = true;
                }
                if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                    status = true;
                }
                status = (activeNetwork != null && activeNetwork.isConnected());
            }
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    /**
     * @param context
     */
    public static void internetFailedDialog(Context context) {
        try {
            if (mDialog != null && mDialog.isShowing()) {
                return;
            }
            if (context == null) {
                return;
            }
            AlertDialog.Builder mAlertDialogBuilder = new AlertDialog.Builder(context);
            mAlertDialogBuilder.setTitle("Internet Problem");
            mAlertDialogBuilder
                    .setMessage("Please check your internet connection and try again!");
            mAlertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert);
            mAlertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (mDialog != null) {
                        mDialog.dismiss();
                        mDialog.cancel();
                    }
                    mDialog = null;
                }
            });
            mDialog = mAlertDialogBuilder.create();
            mDialog.show();
        } catch (Exception e) {
            Logger.logException(e);
        }
    }

    private static AlertDialog dialog;

    /**
     * @param act
     * @param message
     * @param
     */
    public static void showStatusDialog(final Activity act, final String title, final String message, final boolean isToken) {

        if (act != null && !act.isFinishing()) {
            act.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            act);
                    alertDialogBuilder.setTitle(title);
                    alertDialogBuilder.setMessage(message);
                    alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert);
                    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            dialog.cancel();
                        }
                    });
                    try {
                        if (dialog != null /*&& dialog.isShowing()*/) {
                            dialog.dismiss();
//                            dialog = null;
                        }
                        dialog = null;
                        dialog = alertDialogBuilder.create();
                        dialog.show();
                    } catch (Exception e) {
                        Logger.logException(e);
                    }
                }
            });
        }
    }

    /**
     * Checks if internet is connected/available by pinning google.com
     *
     * @return boolean i.e. true if internet is connected and false otherwise.
     */
    public static Boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {

            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int exitValue = ipProcess.waitFor();
            return (exitValue == 0);

        } catch (IOException e) {
            Logger.logException(e);
        } catch (InterruptedException e) {
            Logger.logException(e);
        }

        return false;

    }

    /**
     * @param context
     * @return
     */
    public static boolean isMobileConnected(Context context) {
        try {
            final ConnectivityManager connMgr = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            final android.net.NetworkInfo mobile = connMgr
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            return mobile.isConnected();
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean isWifiConnected(Context context) {
        try {
            final ConnectivityManager connMgr = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            final android.net.NetworkInfo wifi = connMgr
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            return wifi.isConnected();
        } catch (Exception e) {
            return false;
        }
    }

}
