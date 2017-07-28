package com.example.kienpt.a13androiddrawing1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class RectView extends View {
    private Paint paint;

    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.STROKE);
    }

    public RectView(Context context) {
        super(context);
    }

    public RectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = 300;
        float height = 350;
        float left = (getWidth() - width) / 2.0f;
        float top = (getHeight() - height) / 2.0f;
        canvas.drawRect(left, top, left + width, top + height, paint);
        canvas.drawLine(left, top, left + width, top + height, paint);
        canvas.drawLine(left, top + height, left + width, top, paint);
        canvas.drawLine(left + width / 2.0f, top, left + width / 2.0f, top + height, paint);
        canvas.drawLine(left, top + height / 2.0f, left + width, top + height / 2.0f, paint);
    }
}
