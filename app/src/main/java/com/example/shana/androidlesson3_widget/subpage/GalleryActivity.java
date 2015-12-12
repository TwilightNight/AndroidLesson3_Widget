package com.example.shana.androidlesson3_widget.subpage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.shana.androidlesson3_widget.R;
import com.example.shana.androidlesson3_widget.adapter.ImageAdapter;
import com.example.shana.androidlesson3_widget.utils.ConvertDpPx;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by shana on 2015/12/10.
 * Gallery is no longer supported.
 */
public class GalleryActivity extends Activity {
    @Bind(R.id.activity_gallery_gallery)
    Gallery gallery;
    @Bind(R.id.activity_gallery_image_switcher)
    ImageSwitcher imageSwitcher;

    @OnItemClick(R.id.activity_gallery_gallery)
    void onGalleryItemClick(int position){
        imageSwitcher.setImageResource((int) gallery.getItemIdAtPosition(position));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);
        setupImageSwitcher();
        setupGallery();
    }

    private void setupImageSwitcher(){
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(GalleryActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        imageSwitcher.setImageResource(R.drawable.cat01);
    }

    private void setupGallery(){
        gallery.setAdapter(new ImageAdapter(getResources().obtainTypedArray(R.array.cat_array), new Gallery.LayoutParams(
                (int) ConvertDpPx.convertDpToPixel(100.0f, this), (int)ConvertDpPx.convertDpToPixel(100.0f, this))));
    }
}
