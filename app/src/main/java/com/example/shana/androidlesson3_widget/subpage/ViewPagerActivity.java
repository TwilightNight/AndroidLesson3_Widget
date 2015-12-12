package com.example.shana.androidlesson3_widget.subpage;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import com.example.shana.androidlesson3_widget.R;
import com.example.shana.androidlesson3_widget.utils.ImageSwitherUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnPageChange;

/**
 * Created by shana on 2015/12/12.
 */
public class ViewPagerActivity extends Activity {
    private TypedArray resource;
    @Bind(R.id.activity_view_pager_view_pager)
    ViewPager viewPager;
    @Bind(R.id.activity_view_pager_image_switcher)
    ImageSwitcher imageSwitcher;
    @OnPageChange(R.id.activity_view_pager_view_pager)
    void updateImageSwitcher(int position) {
        imageSwitcher.setImageDrawable(resource.getDrawable(position));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);
        resource = getResources().obtainTypedArray(R.array.cat_array);
        ImageSwitherUtils.setupDefaultStyle(this, imageSwitcher);
        setupViewPager();
    }

    private void setupViewPager(){
        final ArrayList<View> imageList = getImageList();
        PagerAdapter adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return imageList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(imageList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(imageList.get(position));
                return imageList.get(position);
            }
        };
        viewPager.setAdapter(adapter);
        updateImageSwitcher(0);
    }

    private ArrayList<View> getImageList(){
        ArrayList<View> imageList = new ArrayList<>();
        for (int i = 0; i < resource.length(); i++) {
            ImageView image = new ImageView(this);
            image.setImageDrawable(resource.getDrawable(i));
            imageList.add(image);
        }
        return imageList;
    }
}
