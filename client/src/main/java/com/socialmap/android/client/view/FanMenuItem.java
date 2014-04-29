package com.socialmap.android.client.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by yy on 4/27/14.
 */
public class FanMenuItem extends ViewGroup {
    public FanMenuItem(Context context) {
        super(context);
    }

    public FanMenuItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FanMenuItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * Any layout manager that doesn't scroll will want this.
     */
    @Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }
    /**
     * Ask all children to measure themselves and compute the measurement of this
     * layout based on the children.
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    /**
     * Position all children within this layout.
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

    }
}
