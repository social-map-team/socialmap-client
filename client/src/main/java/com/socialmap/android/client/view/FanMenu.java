package com.socialmap.android.client.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yy on 4/27/14.
 */
public class FanMenu extends ViewGroup {
    public FanMenu(Context context) {
        super(context);
    }

    public FanMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FanMenu(Context context, AttributeSet attrs, int defStyle) {
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
        int count = getChildCount();
        List<View> nakedViews = new ArrayList<View>();
        List<FanMenuLayer> layers = new ArrayList<FanMenuLayer>();
        for(int i=0;i<count;i++){
            View child = getChildAt(i);
            if(child instanceof FanMenuLayer){
                layers.add((FanMenuLayer)child);
            }else{
                nakedViews.add(child);
            }
        }
        if(layers.isEmpty()){
            layers.add(new FanMenuLayer(getContext()));
        }
        FanMenuLayer layer0 = layers.get(0);
        for(View v : nakedViews){
            layer0.addView(v);
        }
        removeAllViews();
        Button centerButton = new Button(getContext());
        addView(centerButton);
        for(FanMenuLayer layer:layers){
            addView(layer);
        }
        setMeasuredDimension(50+layers.size()*50,50+layers.size()*50);
    }
    /**
     * Position all children within this layout.
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

    }




}
