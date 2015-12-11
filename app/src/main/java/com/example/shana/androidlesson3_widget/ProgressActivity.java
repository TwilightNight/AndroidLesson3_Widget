package com.example.shana.androidlesson3_widget;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

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

        final Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                progressBar.incrementSecondaryProgressBy(1);
                setSecondaryProgress(100*progressBar.getSecondaryProgress());
            }
        };

        final Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(-100);
                setSecondaryProgress(100*progressBar.getSecondaryProgress());
            }
        };

        final Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                textView.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
            }
        };

        final Handler handler = new Handler();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < progressBar.getMax() / 10; i++) {
                        for (int j = 0; j < progressBar.getMax(); j++) {
                            Thread.sleep(10);
                            handler.post(runnable1);
                        }
                        handler.post(runnable2);
                    }
                    handler.post(runnable3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
