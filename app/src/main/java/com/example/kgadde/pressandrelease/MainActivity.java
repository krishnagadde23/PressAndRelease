package com.example.kgadde.pressandrelease;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{
    protected MyTextView[] textViews;
    protected ViewGroup layout;
    protected myOnTouchListener listener;

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViews = new MyTextView[] {(MyTextView) findViewById(R.id.t1_textView), (MyTextView) findViewById(R.id.t2_textView),
                (MyTextView) findViewById(R.id.t3_textView), (MyTextView) findViewById(R.id.t4_textView)};
        layout = (ViewGroup) findViewById(R.id.layout);
        listener = new myOnTouchListener();

        for(int x = 0; x < textViews.length; x++)
        {
            final int y = x;
            textViews[x].setOnTouchListener(listener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class myOnTouchListener implements View.OnTouchListener
    {
        public boolean onTouch(View v, MotionEvent event)
        {

            if(event.getAction() == MotionEvent.ACTION_UP)
            {
                View up = (MyTextView) ((CustomLayout) layout).getUp();
                if(up == null)
                    return false;
                int down = Arrays.asList(textViews).indexOf(v);
                ((MyTextView) up).incrementAndUpdate(down);
                return false;
            }
            return true;
        }
    }
}