package com.socialmap.android.client.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yy on 4/27/14.
 */
public class FanButton extends View {
    private Paint paint;

    public FanButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.argb(200,100,100,20));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(600,600);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(600,600,200,paint);
        paint.setStrokeWidth(5);
        paint.setColor(Color.argb(170,100,100,20));
        canvas.drawCircle(600,600,400,paint);
        paint.setColor(Color.argb(140,100,100,20));
        canvas.drawCircle(600,600,600,paint);

    }
}
