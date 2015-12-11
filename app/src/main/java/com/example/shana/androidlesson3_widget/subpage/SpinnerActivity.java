package com.example.shana.androidlesson3_widget.subpage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.shana.androidlesson3_widget.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

/**
 * Created by shana on 2015/12/10.
 */
public class SpinnerActivity extends Activity {
    @Bind(R.id.activity_spinner_text_view)
    TextView textView;
    @Bind(R.id.activity_spinner_spinner)
    Spinner spinner;
    @OnItemSelected(R.id.activity_spinner_spinner)
    void onSpinnerSelectItem(){
        textView.setText("You selected planet is " + spinner.getSelectedItem().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
