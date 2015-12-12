package com.example.shana.androidlesson3_widget.subpage;

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
    @Bind(R.id.activity_horizontal_scroll_view_horizontal_scroll_view)
    HorizontalScrollView horizontalScrollView;
    @Bind(R.id.activity_horizontal_scroll_view_Shape)
    LinearLayout shape;
    @Bind(R.id.activity_horizontal_scroll_view_ImageSwitcher)
    ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_scroll_view);
        ButterKnife.bind(this);
        resource = getResources().obtainTypedArray(R.array.cat_array);
        ImageSwitcherUtils.setupDefaultStyle(this, imageSwitcher);
        setupHorizontalScrollView();
    }

    private void setupHorizontalScrollView() {
        ArrayList<View> imageList = ResourceUtils.getImageList(this, resource);
        for (final View image : imageList) {
            image.setTag(imageList.indexOf(image));
            image.setLayoutParams(new LinearLayout.LayoutParams((int) ConvertDpPx.convertDpToPixel(100, this), (int) ConvertDpPx.convertDpToPixel(100, this)));
            image.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            shape.setTag(horizontalScrollView.getScrollX());
                            break;
                        case MotionEvent.ACTION_UP:
                            if ((int)shape.getTag() <= horizontalScrollView.getScrollX() + 10 && (int)shape.getTag() >= horizontalScrollView.getScrollX() - 10) {
                                imageSwitcher.setImageDrawable(resource.getDrawable((int)v.getTag()));
                            }
                            break;
                    }
                    return true;
                }
            });
            shape.addView(image);
        }
    }
}
