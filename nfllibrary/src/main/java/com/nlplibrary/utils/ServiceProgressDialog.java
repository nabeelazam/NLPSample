package com.nlplibrary.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.nlplibrary.R;

import at.grabner.circleprogress.CircleProgressView;


public class ServiceProgressDialog extends Dialog {

    public static float DIM_AMOUNT = 0.6f, SPIN_SPEED = 5.0f;

    private static ServiceProgressDialog mDialog;
    private static Activity mContext;
    private static CircleProgressView mCircleProgressView;

    private ServiceProgressDialog(Context context) {
        super(context);
    }

    private ServiceProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    /**
     * show custom progress dialog.
     */
    public static void showDialog(final Activity context) {

        if (context == null) {
            return;
        }
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.cancel();
            mDialog.dismiss();
        }
        mDialog = null;
        mContext = context;
        mDialog = new ServiceProgressDialog(context, R.style.customDialogStyle);
        mDialog.setContentView(R.layout.custom_progress_dialog);
        mDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        resetProgressView();
        mCircleProgressView = (CircleProgressView) mDialog.findViewById(R.id.circleView);
        mCircleProgressView.setShowTextWhileSpinning(false);
        mCircleProgressView.spin();
        mCircleProgressView.setSpinSpeed(SPIN_SPEED);
        mCircleProgressView.setVisibility(View.VISIBLE);
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(true);
        WindowManager.LayoutParams lp = mDialog.getWindow().getAttributes();
        lp.dimAmount = DIM_AMOUNT;

        mDialog.getWindow().setAttributes(lp);
        try {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (mDialog != null && !mDialog.isShowing()) {
                            mDialog.show();
                        }
                    } catch (Exception ignore) {
                        Logger.logException(ignore);
                    }
                }
            });
        } catch (Exception e) {
            Logger.logException(e);
        }
    }

    /**
     *
     */
    private static void resetProgressView() {
        try {
            if (mCircleProgressView != null) {
                mCircleProgressView.stopSpinning();
                mCircleProgressView.clearAnimation();
                mCircleProgressView = null;
            }
        } catch (Exception e) {
            Logger.logException(e);
        }
    }

    /**
     * @param context
     */
    public static void showDialogNotCancelable(Activity context) {
        if (context == null) {
            return;
        }
        showDialog(context);
        if (mDialog != null) {
            mDialog.setCancelable(false);
            mDialog.setCanceledOnTouchOutside(false);
        }
    }


    public static void dismissDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.cancel();
            mDialog.dismiss();
            mDialog = null;
            resetProgressView();
        }
    }

    /**
     * On cancel listener.
     *
     * @param listener
     */
    public void setOnCancelListener(DialogInterface.OnCancelListener listener) {
        mDialog.setOnCancelListener(listener);
    }

    /**
     * on dissmiss listener.
     *
     * @param listener
     */
    public void setOnDismissListener(DialogInterface.OnDismissListener listener) {
        mDialog.setOnDismissListener(listener);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mContext != null) {
            mContext.onBackPressed();
        }
    }

    public static void dismissDialogWithUi(FragmentActivity activity) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ServiceProgressDialog.dismissDialog();
                }
            });
        }
    }


    /**
     * @param message
     */
    public static void showToastMsg(final Activity activity, final String message) {
        if (activity != null) {
            if (!message.isEmpty()) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast toast =
                                Toast.makeText(activity, message, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
        }
    }
}
