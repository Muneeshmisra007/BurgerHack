package com.burgerhack.core.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * An assortment of UI related utility methods.
 * <p>
 * Created by Amritpal Singh on 8/29/16.
 */
public class UIUtils {

    public static void loadImageUrlIntoImageView(Context context, ImageView imageView, String url) {
        Glide.with(context).load(url).into(imageView);
    }

    public static void showSoftInputMode(Context context, View view) {
        if (view == null) return;
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.RESULT_UNCHANGED_SHOWN);
    }

    public static void hideSoftInputMode(Context context, View view) {

        if (view == null) return;
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
    }

    public static final boolean checkNotNull(Object object) {
        return object != null;
    }
}


