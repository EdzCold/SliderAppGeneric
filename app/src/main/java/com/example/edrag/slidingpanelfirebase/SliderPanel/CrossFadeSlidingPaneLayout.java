package com.example.edrag.slidingpanelfirebase.SliderPanel;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by edrag on 11/11/2017.
 */

public class CrossFadeSlidingPaneLayout extends SlidingPaneLayout {

    private View partialView = null;
    private View fullView = null;

    public CrossFadeSlidingPaneLayout(Context context) {
        super(context);
    }

    public CrossFadeSlidingPaneLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CrossFadeSlidingPaneLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return false;
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        return false;
//    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        if (getChildCount() < 1) {
            return;
        }

        View panel = getChildAt(0);
        if (!(panel instanceof ViewGroup)) {
            return;
        }

        ViewGroup viewGroup = (ViewGroup) panel;
        if (viewGroup.getChildCount() != 2) {
            return;
        }
        fullView = viewGroup.getChildAt(0);
        partialView = viewGroup.getChildAt(1);

        super.setPanelSlideListener(crossFadeListener);
    }

    private SimplePanelSlideListener crossFadeListener
            = new SimplePanelSlideListener() {
        @Override
        public void onPanelSlide(View panel, float slideOffset) {
            super.onPanelSlide(panel, slideOffset);
            if (partialView == null || fullView == null) {
                return;
            }
//            partialView.setVisibility(isOpen() ? View.GONE : VISIBLE);
            partialView.setVisibility(VISIBLE);
//            partialView.setAlpha(1 - slideOffset);
            fullView.setAlpha(slideOffset);
        }
    };

    @Override
    protected void onLayout(
            boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        if (partialView != null) {
//            partialView.setVisibility(isOpen() ? View.GONE : VISIBLE);
            partialView.setVisibility(VISIBLE);

        }
    }
}
