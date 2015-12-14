package com.example.shana.androidlesson3_widget.activities.subpage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shana.androidlesson3_widget.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shana on 2015/12/10.
 */
public class ProgressActivity extends Activity {
    @Bind(R.id.activity_progress_image_view)
    ImageView imageView;
    @Bind(R.id.activity_progress_progress_bar)
    ProgressBar progressBar;
    @Bind(R.id.activity_progress_text_view)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        ButterKnife.bind(this);
        beginLoading();
    }

    private void beginLoading(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (progressBar.getSecondaryProgress() < progressBar.getMax()) {
                    progressBar.incrementSecondaryProgressBy(1);
                    handler.postDelayed(this, 10);
                } else if (progressBar.getProgress() < progressBar.getMax()) {
                    progressBar.incrementProgressBy(20);
                    progressBar.setSecondaryProgress(0);
                    handler.postDelayed(this, 10);
                } else {
                    textView.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
