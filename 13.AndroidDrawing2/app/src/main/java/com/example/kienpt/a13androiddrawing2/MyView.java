package com.example.kienpt.a13androiddrawing2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import java.util.Random;

public class MyView extends View {

    private FrameLayout.LayoutParams params;
    private Rect r = new Rect();
    private Paint paint;
    private Paint rectPaint;


    private void initPaint() {
        params = new FrameLayout.LayoutParams(0, 0);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPaint();
    }

    private void drawTextBounds(Canvas canvas, Rect rect, int x, int y) {
        rectPaint.setColor(Color.BLACK);
        rectPaint.setStrokeWidth(2f);
        rectPaint.setStyle(Paint.Style.STROKE);
        rect.offset(x, y);
        canvas.drawRect(rect, rectPaint);
    }

    private void draw(Canvas canvas, Paint paint, String text, float left, float top) {
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setColor(Color.BLACK);
        canvas.getClipBounds(r);
        paint.getTextBounds(text, 0, text.length(), r);
        float x = top / 2f - r.width() / 2f - r.left;
        float y = left / 2f + r.height() / 2f - r.bottom;
//        int angle = RandomUtils.randomInt(180);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.rotate(10);
        drawTextBounds(canvas, r, (int) x, (int) y);
        canvas.drawText(text, x, y, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int margin = 10;
        int width = w - 2 * margin;
        int height = h - 2 * margin;
        params.width = width;
        params.height = height;
        params.leftMargin = margin;
        params.topMargin = margin;
        setLayoutParams(params);
        float TEXT_HEIGHT_RATIO = 0.1f;
        paint.setTextSize(height * TEXT_HEIGHT_RATIO);
        paint.setAntiAlias(true);
        paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.BOLD_ITALIC));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float l = (getWidth() - 300) / 2.0f;
        float t = (getHeight() - 300) / 2.0f;
        Paint rpaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rpaint.setStrokeWidth(2f);
        rpaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(l, t, l + 300, t + 300, rpaint);
        drawRandomBitmap(canvas, getWidth(), getHeight());
        drawRandomBitmap(canvas, getWidth(), getHeight());
        drawRandomBitmap(canvas, getWidth(), getHeight());
        drawRandomBitmap(canvas, getWidth(), getHeight());
        drawRandomBitmap(canvas, getWidth(), getHeight());
        drawRandomBitmap(canvas, getWidth(), getHeight());
        drawRandomBitmap(canvas, getWidth(), getHeight());
        drawRandomBitmap(canvas, getWidth(), getHeight());
        drawRandomBitmap(canvas, getWidth(), getHeight());
        drawRandomBitmap(canvas, getWidth(), getHeight());
        drawRandomBitmap(canvas, getWidth(), getHeight());

    }

    private void drawRandomBitmap(Canvas canvas, int viewWidth, int viewHeight) {
        float left = RandomUtils.randomFloat(viewWidth);
        float top = RandomUtils.randomFloat(viewHeight);
        String LABEL = "Wow!";
        draw(canvas, paint, LABEL, left, top);
        canvas.rotate(20);

    }
}

class RandomUtils {
    private static Random r = new Random();

    static int randomInt(int range) {
        return (r.nextInt(range));
    }

    private static int randomIndex(Object[] array) {
        return (randomInt(array.length));
    }

    static <T> T randomElement(T[] array) {
        return (array[randomIndex(array)]);
    }

    static float randomFloat(int n) {
        return ((float) Math.random() * n);
    }
}

