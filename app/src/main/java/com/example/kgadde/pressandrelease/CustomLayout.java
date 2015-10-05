package com.example.kgadde.pressandrelease;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

/**
 * Created by 2016kgadde on 10/5/2015.
 */
public class CustomLayout extends RelativeLayout {
    private MyView v1, v2, v3, v4;

    public CustomLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);

    }
}
