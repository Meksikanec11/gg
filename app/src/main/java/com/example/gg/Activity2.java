package com.example.gg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.content.Intent;

public class Activity2 extends AppCompatActivity {
    double x1 = 0.0;
    double x2 = 0.0;
    double y1 = 0.0;
    double y2 = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
      }
      public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();

                if ((x2<x1)&((y2<=y1+100)&(y2>=y1-100))){
                    Intent intent = new Intent( this, serGay.class);
                    startActivity(intent);
                }
                break;
        }
        return false;
      }
}