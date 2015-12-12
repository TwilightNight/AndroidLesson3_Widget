package com.example.shana.androidlesson3_widget.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by shana on 2015/12/12.
 */
public class ResourceUtils {
    public static ArrayList<View> getImageList(Context context, TypedArray resource){
        ArrayList<View> imageList = new ArrayList<>();
        for (int i = 0; i < resource.length(); i++) {
            ImageView image = new ImageView(context);
            image.setImageDrawable(resource.getDrawable(i));
            image.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageList.add(image);
        }
        return imageList;
    }
}
