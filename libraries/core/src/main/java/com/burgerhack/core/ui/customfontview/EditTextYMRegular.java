package com.burgerhack.core.ui.customfontview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.util.AttributeSet;

/**
 * Created by Amritpal Singh on 19/10/18.
 */
public class EditTextYMRegular extends TextInputEditText {

    public EditTextYMRegular(Context context) {
        super(context);
    }

    public EditTextYMRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextYMRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        createFont();
    }

    public void createFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Yantramanav-Regular.ttf");
        setTypeface(font);

    }
}
