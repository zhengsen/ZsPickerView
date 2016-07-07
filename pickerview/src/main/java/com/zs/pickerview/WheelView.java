package com.zs.pickerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhengsen on 2016/7/6.
 */
public class WheelView extends View {
    private Context context;

    private int asideTextColor;
    private int selectedTextColor;
    private int asideTextSize;
    private int selectedTextSize;

    public WheelView(Context context) {
        super(context);
        this.context = context;
        initParams();
    }

    public WheelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initParams();
        if (attrs != null) {
            getAttributes(attrs);
        }
    }

    public WheelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initParams();
    }

    private void initParams() {
        asideTextColor = Color.GRAY;
        asideTextSize = context.getResources().getDimensionPixelSize(R.dimen.font_size_small);
        selectedTextColor = Color.DKGRAY;
        selectedTextSize = context.getResources().getDimensionPixelSize(R.dimen.font_size_normal);
    }

    private void getAttributes(AttributeSet attributeSet) {
        @SuppressLint("Recycle") TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CylinderView);
        asideTextColor = typedArray.getColor(R.styleable.CylinderView_cylinder_aside_text_color, Color.GRAY);
        asideTextSize = typedArray.getDimensionPixelSize(R.styleable.CylinderView_cylinder_aside_text_size,
                context.getResources().getDimensionPixelOffset(R.dimen.font_size_small));
        selectedTextColor = typedArray.getColor(R.styleable.CylinderView_cylinder_selected_text_color, Color.DKGRAY);
        selectedTextSize = typedArray.getDimensionPixelSize(R.styleable.CylinderView_cylinder_selected_text_size,
                context.getResources().getDimensionPixelOffset(R.dimen.font_size_normal));
    }


}
