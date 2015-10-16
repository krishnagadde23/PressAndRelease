package com.example.kgadde.pressandrelease;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by 2016kgadde on 10/5/2015.
 */
public class CustomLayout extends RelativeLayout
{
    private View myUp;
    public CustomLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        myUp = null;
    }

    public View getUp()
    {
        return myUp;
    }
    public void setUp(View v)
    {
        myUp = v;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        if(ev.getAction() == MotionEvent.ACTION_UP)
        {
            myUp = inViewBounds(ev);
        }
        return false;
    }

    public View inViewBounds(MotionEvent ev)
    {
        Rect viewRect = new Rect();
        int[] loc = new int[2];
        int rx = (int) ev.getRawX();
        int ry = (int) ev.getRawY();
        for(int i = 0; i < ((ViewGroup) this).getChildCount(); i++)
        {
            View child = ((ViewGroup) this).getChildAt(i);
            child.getDrawingRect(viewRect);
            child.getLocationOnScreen(loc);
            viewRect.offset(loc[0], loc[1]);
            if(viewRect.contains(rx, ry))
                return child;
        }
        return null;
    }
}