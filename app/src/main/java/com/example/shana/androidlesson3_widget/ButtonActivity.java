package com.example.shana.androidlesson3_widget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shana on 2015/12/10.
 */
public class ButtonActivity extends Activity {
    @Bind(R.id.activity_button_text_view)
    TextView textView;
    @Bind(R.id.activity_button_radio_group)
    RadioGroup radioGroup;
    @OnClick(R.id.activity_button_button)
    void onRegularButtonClick(){
        textView.setText("onRegularButtonClick");
    }

    @OnClick(R.id.activity_button_toggle_button)
    void onTogggleButtonClick(ToggleButton toggleButton) {
        textView.setText("onTogggleButtonClick " + toggleButton.getText().toString());
    }

    @OnClick(R.id.activity_button_image_button)
    void onImageButtonClick() {
        textView.setText("onImageButtonClick");
    }

    @OnClick(R.id.activity_button_check_box)
    void onCheckBoxClick(CheckBox checkBox) {
        textView.setText("onCheckBoxClick" + (checkBox.isChecked() ? "YES" : "NO"));
    }

    @OnClick({R.id.activity_button_radio_button1, R.id.activity_button_radio_button2, R.id.activity_button_radio_button3})
    void onRadioGroupItemClick(RadioButton radioButton) {
        textView.setText("onRadioGroupItemClick " + radioButton.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        ButterKnife.bind(this);
    }
}
