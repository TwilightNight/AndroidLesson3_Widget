package com.example.shana.androidlesson3_widget.adapter;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.shana.androidlesson3_widget.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shana on 2015/12/11.
 */
public class ImageAdapter extends BaseAdapter {
    private TypedArray resource;
    static class ViewHolder {
        @Bind(R.id.adapter_image_image)
        ImageView imageView;
        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
    public ImageAdapter(TypedArray resource){
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return resource.length() * 10;
    }

    @Override
    public Object getItem(int position) {
        return resource.getDrawable(position % resource.length());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            System.out.println("Create new view at " + position);
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_image, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        
        viewHolder.imageView.setImageDrawable((Drawable) getItem(position));
        AbsListView.LayoutParams param = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 400);
        convertView.setLayoutParams(param);
        return convertView;
    }
}
