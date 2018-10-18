package com.recommended.app.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Amritpal Singh on 6/22/17.
 */

public class ConfirmationAlertDialogFragment extends DialogFragment {

    private static final String ARG_MESSAGE = "message";
    private static final String ARG_POSITIVE_TEXT = "positive_text";
    private static final String ARG_NEGATIVE_TEXT = "negative_text";
    private OnDialogButtonClick mListener;

    public static ConfirmationAlertDialogFragment newInstance(@StringRes int message,
                                                              @StringRes int positiveButtonText,
                                                              @StringRes int negativeButtonText) {

        ConfirmationAlertDialogFragment fragment = new ConfirmationAlertDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_MESSAGE, message);
        args.putInt(ARG_POSITIVE_TEXT, positiveButtonText);
        args.putInt(ARG_NEGATIVE_TEXT, negativeButtonText);
        fragment.setArguments(args);
        return fragment;
    }


    public void setOnDialogClickListener(OnDialogButtonClick dialogClickListener) {
        this.mListener = dialogClickListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Bundle args = getArguments();
        return new AlertDialog.Builder(getActivity())
                .setMessage(args.getInt(ARG_MESSAGE))
                .setPositiveButton(args.getInt(ARG_POSITIVE_TEXT),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (mListener != null) {
                                    mListener.onDialogButtonClick(dialog, BUTTONTYPE.POSITIVE);
                                }
                            }
                        })
                .setNegativeButton(args.getInt(ARG_NEGATIVE_TEXT),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (mListener != null) {
                                    mListener.onDialogButtonClick(dialog, BUTTONTYPE.NEGATIVE);
                                }
                            }
                        })
                .create();
    }

    public enum BUTTONTYPE {
        POSITIVE, NEGATIVE;
    }

    public interface OnDialogButtonClick {
        void onDialogButtonClick(DialogInterface dialogInterface, BUTTONTYPE buttontype);
    }
}
