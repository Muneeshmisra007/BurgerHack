package com.burgerhack.core.util;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * An implementation for applying CustomFonts dynamically to the TextViews.
 *
 * Created by Amritpal Singh on 8/29/16.
 */
public class FontUtil {

    private static FontUtil mFontInstance;
    private Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();

    private FontUtil() {

        if (mFontInstance != null) {
            throw new IllegalStateException("No two instances of this class can co-exists.");
        }
    }

    public static final FontUtil getInstance() {
        if (mFontInstance == null) {
            synchronized (FontUtil.class) {
                mFontInstance = new FontUtil();
            }
        }
        return mFontInstance;
    }

    public Typeface get(String name, Context context) {

        Typeface tf = fontCache.get(name);
        if (tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), name);
            } catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }

    public Typeface getYantramanavBlack(Context context) {

        return get("fonts/Yantramanav-Black.ttf", context);
    }

    public Typeface getYantramanavBold(Context context) {

        return get("fonts/Yantramanav-Bold.ttf", context);
    }

    public Typeface getYantramanavLight(Context context) {

        return get("fonts/Yantramanav-Light.ttf", context);
    }

    public Typeface getYantramanavMedium(Context context) {

        return get("fonts/Yantramanav-Medium.ttf", context);
    }

    public Typeface getYantramanavRegular(Context context) {

        return get("fonts/Yantramanav-Regular.ttf", context);
    }

    public Typeface getYantramanavthin(Context context) {

        return get("fonts/Yantramanav-Thin.ttf", context);
    }


}
