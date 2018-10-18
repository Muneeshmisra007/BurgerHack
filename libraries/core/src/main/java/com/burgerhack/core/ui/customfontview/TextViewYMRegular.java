package com.burgerhack.core.ui.customfontview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Amritpal Singh on 19/10/18.
 */
public class TextViewYMRegular extends AppCompatTextView {

    public TextViewYMRegular(Context context) {
        super(context);
    }

    public TextViewYMRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextViewYMRegular(Context context, AttributeSet attrs, int defStyleAttr) {
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
