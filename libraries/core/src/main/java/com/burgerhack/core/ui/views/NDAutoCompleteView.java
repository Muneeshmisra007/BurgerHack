package com.burgerhack.core.ui.views;

import android.content.Context;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Amritpal Singh on 19/10/18.
 */
public class NDAutoCompleteView extends AppCompatAutoCompleteTextView {

    public NDAutoCompleteView(Context context) {
        super(context);
    }

    public NDAutoCompleteView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NDAutoCompleteView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (getAdapter() != null) {
                    showDropDown();
                }
                return false;
            }
        });
    }
}
