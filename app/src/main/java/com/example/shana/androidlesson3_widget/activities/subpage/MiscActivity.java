package com.example.shana.androidlesson3_widget.activities.subpage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.shana.androidlesson3_widget.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shana on 2015/12/10.
 */
public class MiscActivity extends Activity {
    @Bind(R.id.activity_misc_rating_text_view)
    TextView ratingTextView;
    @Bind(R.id.activity_misc_seek_text_view)
    TextView seekTextView;
    @Bind(R.id.activity_misc_rating_bar)
    RatingBar ratingBar;
    @Bind(R.id.activity_misc_seek_bar)
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misc);
        ButterKnife.bind(this);
        initWidget();
    }

    private void initWidget(){
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingTextView.setText("Current rating = " + rating);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekTextView.setText("Current seek = " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        setInitValueForWidget();
    }

    private void setInitValueForWidget(){
        ratingBar.setRating(3);
        seekBar.setProgress(50);
    }
}
