package com.example.shana.androidlesson3_widget.subpage;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.shana.androidlesson3_widget.R;
import com.example.shana.androidlesson3_widget.adapter.ImageAdapter;
import com.example.shana.androidlesson3_widget.utils.ConvertDpPx;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by shana on 2015/12/10.
 */
public class GridActivity extends Activity {
    @Bind(R.id.activity_grid_grid_view)
    GridView gridView;
    @OnItemClick(R.id.activity_grid_grid_view)
    void onGridViewItemCilck(int position){
        Toast.makeText(this, "meow at " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        ButterKnife.bind(this);
        gridView.setAdapter(new ImageAdapter(getResources().obtainTypedArray(R.array.cat_array), new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, (int) ConvertDpPx.convertDpToPixel(200.0f, this))));
    }
}
