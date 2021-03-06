package com.example.shana.androidlesson3_widget.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shana.androidlesson3_widget.R;
import com.example.shana.androidlesson3_widget.activities.subpage.ButtonActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.ChronometerActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.ClockActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.DateTimePickerActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.EditActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.GalleryActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.GridActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.HorizontalScrollViewActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.MiscActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.PopupActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.ProgressActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.SpinnerActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.VideoActivity;
import com.example.shana.androidlesson3_widget.activities.subpage.ViewPagerActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by shana on 2015/12/10.
 */
public class WidgetActivity extends Activity {
    private Object[] activities = {
            "Button", ButtonActivity.class,
            "Edit", EditActivity.class,
            "Clock", ClockActivity.class,
            "Progress", ProgressActivity.class,
            "Date/Time Picker", DateTimePickerActivity.class,
            "Chronometer", ChronometerActivity.class,
            "Popup", PopupActivity.class,
            "SpinnerSelect", SpinnerActivity.class,
            "GridView", GridActivity.class,
            "Video", VideoActivity.class,
            "Gallery(deprecated)", GalleryActivity.class,
            "ViewPager", ViewPagerActivity.class,
            "HorizontalScrollView", HorizontalScrollViewActivity.class,
            "Misc", MiscActivity.class
    };

    @Bind(R.id.activity_widget_list_view)
    ListView listView;

    @OnItemClick(R.id.activity_widget_list_view)
    void onListViewItemClick(int position){
        startActivity(new Intent(this, (Class)activities[position*2 + 1]));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        ButterKnife.bind(this);
        listView.setAdapter(new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, getWidgetList()));
    }

    private CharSequence[] getWidgetList(){
        CharSequence[] list = new CharSequence[activities.length/2];
        for (int i = 0; i < list.length; i++) {
            list[i] = (String)activities[i*2];
        }
        return list;
    }
}
