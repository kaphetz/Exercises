package com.example.kienpt.a13androiddrawing1;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class RandomIconView extends View {
    private Bitmap[] mPics = {makeBitmap(R.drawable.animals),
            makeBitmap(R.drawable.black_cat),
            makeBitmap(R.drawable.cat),
            makeBitmap(R.drawable.cat_3),
            makeBitmap(R.drawable.cat_6_2),
            makeBitmap(R.drawable.dog),
            makeBitmap(R.drawable.dog_robot_sh),
            makeBitmap(R.drawable.dragon_fly),
            makeBitmap(R.drawable.elephant),
            makeBitmap(R.drawable.fish),
            makeBitmap(R.drawable.frog),
            makeBitmap(R.drawable.hp_dog),
            makeBitmap(R.drawable.kbugbuster),
            makeBitmap(R.drawable.ksnake),
            makeBitmap(R.drawable.mail),
            makeBitmap(R.drawable.turtle),
            makeBitmap(R.drawable.remember_the_milk)};

    public RandomIconView(Context context) {
        super(context);
    }

    public RandomIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        // choose random 10 icons from array
        for (int i = 0; i < 10; i++) {
            drawRandomBitmap(canvas, viewWidth, viewHeight);
        }
    }

    //draw icon
    private void drawRandomBitmap(Canvas canvas, int viewWidth, int viewHeight) {
        float left = RandomUtils.randomFloat(viewWidth);
        float top = RandomUtils.randomFloat(viewHeight);
        Bitmap pic = RandomUtils.randomElement(mPics);
        canvas.drawBitmap(pic, left, top, null);
    }

    private Bitmap makeBitmap(int bitmapID) {
        return (BitmapFactory.decodeResource(getResources(), bitmapID));
    }


}

class RandomUtils {
    private static Random r = new Random();

    private static int randomInt(int range) {
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