package com.example.shana.androidlesson3_widget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shana on 2015/12/10.
 */
public class WidgetActivity extends Activity {
    private Object[] activities = {
            "Button", ButtonActivity.class,
            "Edit", EditActivity.class,
            "Clock", ClockActivity.class,
            "Progress", ProgerssActivity.class,
            "Date/Time Picker", DateTimePickerActivity.class,
            "Chronometer", ChronometerActivity.class,
            "Popup", PopupActivity.class,
            "SpinnerSelect", SpinnerActivity.class,
            "GridView", GridActivity.class,
            "Video", VideoActivity.class,
            "Gallery", GalleryActivity.class,
            "Misc", MiscActivity.class
    };

    @Bind(R.id.activity_widget_list_view)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        ButterKnife.bind(this);
        CharSequence list = new CharSequence[];
        listView.setAdapter(new ArrayAdapter<CharSequence>(this, android.R.simple_list_item_1, list));
    }
}
