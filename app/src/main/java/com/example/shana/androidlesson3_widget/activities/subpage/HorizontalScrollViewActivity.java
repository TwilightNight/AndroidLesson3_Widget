package com.example.shana.androidlesson3_widget.activities.subpage;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageSwitcher;
import android.widget.LinearLayout;

import com.example.shana.androidlesson3_widget.R;
import com.example.shana.androidlesson3_widget.utils.ConvertDpPx;
import com.example.shana.androidlesson3_widget.utils.ImageSwitcherUtils;
import com.example.shana.androidlesson3_widget.utils.ResourceUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shana on 2015/12/12.
 */
public class HorizontalScrollViewActivity extends Activity {
    private TypedArray resource;
    private int scrollXWhenTouchDown;
    @Bind(R.id.activity_horizontal_scroll_view_horizontal_scroll_view)
    HorizontalScrollView horizontalScrollView;
    @Bind(R.id.activity_horizontal_scroll_view_Image_Scope)
    LinearLayout imageScope;
    @Bind(R.id.activity_horizontal_scroll_view_ImageSwitcher)
    ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_scroll_view);
        ButterKnife.bind(this);
        resource = getResources().obtainTypedArray(R.array.cat_array);
        ImageSwitcherUtils.setupDefaultStyle(this, imageSwitcher);
        imageSwitcher.setImageDrawable(resource.getDrawable(0));
        setupHorizontalScrollView();
    }

    private void setupHorizontalScrollView() {
        ArrayList<View> imageList = ResourceUtils.getImageList(this, resource);
        for (int indexOfImage = 0; indexOfImage < imageList.size(); indexOfImage++){
            View imageView = imageList.get(indexOfImage);
            imageView.setLayoutParams(new LinearLayout.LayoutParams((int) ConvertDpPx.convertDpToPixel(100, this), (int) ConvertDpPx.convertDpToPixel(100, this)));
            viewSetClickEvent(indexOfImage, imageView);
            imageScope.addView(imageView);
        }
    }

    private void viewSetClickEvent(int indexOfView, View view) {
        view.setTag(indexOfView);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View touchView, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        scrollXWhenTouchDown = horizontalScrollView.getScrollX();
                        break;
                    case MotionEvent.ACTION_UP:
                        int scrollXWhenTouchUp = horizontalScrollView.getScrollX();
                        if (scrollXWhenTouchDown < scrollXWhenTouchUp + 10 && scrollXWhenTouchDown > scrollXWhenTouchDown - 10) {
                            imageSwitcher.setImageDrawable(resource.getDrawable((int)touchView.getTag()));
                        }
                        break;
                }
                return true;
            }
        });
    }
}
