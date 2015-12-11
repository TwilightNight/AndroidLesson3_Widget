package com.example.shana.androidlesson3_widget.subpage;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.shana.androidlesson3_widget.R;

import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shana on 2015/12/10.
 */
public class ChronometerActivity extends Activity {
    private long timeWhenStopped = 0;
    @BindString(R.string.start)
    String start;
    @BindString(R.string.stop)
    String stop;

    @OnClick(R.id.activity_chronometer_button)
    void onButtonClick(Button button){
        Chronometer chronometer = (Chronometer)findViewById(R.id.activity_chronometer_chronometer);
        if (button.getText().toString().equals(stop)) {
            button.setText(start);
            timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
            chronometer.stop();
        } else {
            button.setText(stop);
            chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
            chronometer.start();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);
        ButterKnife.bind(this);
    }
}
