package com.example.shana.androidlesson3_widget.activities.subpage;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.shana.androidlesson3_widget.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shana on 2015/12/10.
 */
public class DateTimePickerActivity extends Activity {
    @Bind(R.id.activity_date_time_picker_date_text_view)
    TextView dateTextView;
    @Bind(R.id.activity_date_time_picker_time_text_view)
    TextView timeTextView;

    @OnClick(R.id.activity_date_time_picker_date_button)
    void onDateButtOnClick(){
        GregorianCalendar calendar = new GregorianCalendar();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateTextView.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @OnClick(R.id.activity_date_time_picker_time_button)
    void onTimeButtonOnClick() {
        GregorianCalendar calendar = new GregorianCalendar();
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeTextView.setText(hourOfDay % 12 + ":" + minute + " " + (hourOfDay > 12 ? "PM" : "AM"));
            }
        }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), false).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);
        ButterKnife.bind(this);
    }
}
