package com.burgerhack.core.ui.customfontview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by amrit on 5/13/16.
 */
public class TextViewYMBlack extends AppCompatTextView {

    public TextViewYMBlack(Context context) {
        super(context);
    }

    public TextViewYMBlack(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextViewYMBlack(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        createFont();
    }

    public void createFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Yantramanav-Black.ttf");
        setTypeface(font);
    }
}
