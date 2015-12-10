package com.example.shana.androidlesson3_widget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shana on 2015/12/10.
 */
public class ClockActivity extends Activity {
    @Bind(R.id.activity_clock_text_view)
    TextView textView;

    @OnClick(R.id.activity_clock_button)
    void onButtonClick() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        textView.setText("You click at " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        ButterKnife.bind(this);
    }
}
