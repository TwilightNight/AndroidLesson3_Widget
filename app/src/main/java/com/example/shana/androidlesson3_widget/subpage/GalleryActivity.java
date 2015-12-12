package com.example.shana.androidlesson3_widget.subpage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageSwitcher;

import com.example.shana.androidlesson3_widget.R;
import com.example.shana.androidlesson3_widget.adapter.ImageAdapter;
import com.example.shana.androidlesson3_widget.utils.ConvertDpPx;
import com.example.shana.androidlesson3_widget.utils.ImageSwitherUtils;

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
    void updateImageSwitcher(int position){
        imageSwitcher.setImageResource((int) gallery.getItemIdAtPosition(position));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);
        ImageSwitherUtils.setupDefaultStyle(this, imageSwitcher);
        setupGallery();
        updateImageSwitcher(0);
    }

    private void setupGallery(){
        gallery.setAdapter(new ImageAdapter(getResources().obtainTypedArray(R.array.cat_array), new Gallery.LayoutParams(
                (int) ConvertDpPx.convertDpToPixel(100.0f, this), (int)ConvertDpPx.convertDpToPixel(100.0f, this))));
    }
}
