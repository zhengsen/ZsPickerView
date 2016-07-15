package com.zs.pickerview;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by zhengsen on 2016/7/14.
 */

public class CylinderViewGestureListener extends GestureDetector.SimpleOnGestureListener {
    private CylinderView cylinderView;

    public CylinderViewGestureListener(CylinderView cylinderView) {
        this.cylinderView = cylinderView;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return super.onFling(e1, e2, velocityX, velocityY);
    }
}
