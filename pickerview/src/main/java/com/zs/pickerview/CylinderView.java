package com.zs.pickerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by zhengsen on 2016/7/6.
 */
public class CylinderView extends View {

    public enum ACTION {
        CLICK, FILING, DRAGGING
    }

    private Context context;
    private Handler handler;
    private GestureDetector gestureDetector;
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture<?> scheduledFuture;

    private boolean isLoop;//是否是循环的
    private int showItems;//可见的item数量


    /**
     * textColor & textSize
     */
    private int asideTextColor;
    private int selectedTextColor;
    private int asideTextSize;
    private int selectedTextSize;
    /**
     * paints
     */
    private Paint asideTextPaint;
    private Paint centerTextPaint;
    private Paint indicatorPaint;

    private Rect tempRect;

    private List<String> items;

    public CylinderView(Context context) {
        super(context);
        this.context = context;
        initCylinderView();
    }

    public CylinderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        if (attrs != null) {
            getAttributes(attrs);
        }
        initCylinderView();
    }

    public CylinderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initCylinderView();
    }

    private void initCylinderView() {
        handler = new CylinderMessageHandler();
        gestureDetector = new GestureDetector(context, new CylinderViewGestureListener(this));

        initParams();
    }

    private void initParams() {
        asideTextColor = Color.GRAY;
        asideTextSize = context.getResources().getDimensionPixelSize(R.dimen.font_size_small);
        selectedTextColor = Color.DKGRAY;
        selectedTextSize = context.getResources().getDimensionPixelSize(R.dimen.font_size_normal);

        initPaints();
    }

    private void initPaints() {
        asideTextPaint = new Paint();
        asideTextPaint.setColor(asideTextColor);
        asideTextPaint.setAntiAlias(true);
        asideTextPaint.setTypeface(Typeface.DEFAULT);
        asideTextPaint.setTextSize(asideTextSize);

        centerTextPaint = new Paint();
        centerTextPaint.setColor(selectedTextColor);
        centerTextPaint.setAntiAlias(true);
        centerTextPaint.setTypeface(Typeface.DEFAULT);
        centerTextPaint.setTextSize(selectedTextSize);

        indicatorPaint = new Paint();
        indicatorPaint.setAntiAlias(true);


    }

    private void remeasure() {
        if (items == null) {
            return;
        }


    }

    private void getAttributes(AttributeSet attributeSet) {
        @SuppressLint("Recycle")
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CylinderView);
        asideTextColor = typedArray.getColor(R.styleable.CylinderView_cylinder_aside_text_color, Color.GRAY);
        asideTextSize = typedArray.getDimensionPixelSize(R.styleable.CylinderView_cylinder_aside_text_size,
                context.getResources().getDimensionPixelOffset(R.dimen.font_size_small));
        selectedTextColor = typedArray.getColor(R.styleable.CylinderView_cylinder_selected_text_color, Color.DKGRAY);
        selectedTextSize = typedArray.getDimensionPixelSize(R.styleable.CylinderView_cylinder_selected_text_size,
                context.getResources().getDimensionPixelOffset(R.dimen.font_size_normal));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
