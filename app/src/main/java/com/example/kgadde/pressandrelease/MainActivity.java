package com.example.kgadde.pressandrelease;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private int press = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyView v1 = (MyView) findViewById(R.id.t1);
        final MyView v2 = (MyView) findViewById(R.id.t2);
        final MyView v3 = (MyView) findViewById(R.id.t3);
        final MyView v4 = (MyView) findViewById(R.id.t4);

        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        v1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(inViewInBounds(v1, (int)event.getRawX(), (int)event.getRawY())) {
                    v1.incrementAndUpdate(press);
                }
                if(inViewInBounds(v2, (int)event.getRawX(), (int)event.getRawY())) {
                    v1.incrementAndUpdate(press);
                }
                if(inViewInBounds(v2, (int)event.getRawX(), (int)event.getRawY())) {
                    v1.incrementAndUpdate(press);
                }
                if(inViewInBounds(v2, (int)event.getRawX(), (int)event.getRawY())) {
                    v1.incrementAndUpdate(press);
                }

                return true;
            }
        });

        v2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v2.incrementAndUpdate(press);
                return true;
            }
        });

        v3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v3.incrementAndUpdate(press);
                return true;
            }
        });

        v4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v4.incrementAndUpdate(press);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean inViewInBounds(View view, int x, int y){
        Rect outRect = new Rect();
        int[] location = new int[2];
        view.getDrawingRect(outRect);
        view.getLocationOnScreen(location);
        outRect.offset(location[0], location[1]);
        return outRect.contains(x, y);
    }
}
