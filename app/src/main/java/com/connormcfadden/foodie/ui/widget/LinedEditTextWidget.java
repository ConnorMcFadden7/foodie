package com.connormcfadden.foodie.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

import com.connormcfadden.foodie.R;


public class LinedEditTextWidget extends EditText {

    private Paint mPaint;

    public LinedEditTextWidget(Context context, AttributeSet attributes) {
        super(context, attributes);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(getResources().getColor(R.color.actionbar_bg_primary_orange));
    }

    //todo line is hardcoded atm, everytime 'Next' on keyboard is clicked it should update a counter which
    //todo determines the line count
    @Override
    protected void onDraw(Canvas canvas) {
        int count = getLineCount() < 3 ? 3 : getLineCount();

        for (int i = 1; i <= count; i++) {
            float height = (getLineHeight()*i) - (getLineHeight()/3) + getPaddingTop();
            canvas.drawLine(getPaddingLeft(), height, getWidth()-getPaddingRight(), height, mPaint);
        }
        super.onDraw(canvas);
    }

}
