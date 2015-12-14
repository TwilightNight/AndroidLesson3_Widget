package com.example.shana.androidlesson3_widget.activities.subpage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

import com.example.shana.androidlesson3_widget.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shana on 2015/12/10.
 */
public class EditActivity extends Activity {
    @Bind(R.id.activity_edit_edit_text)
    EditText editText;
    @Bind(R.id.activity_edit_auto_complete_text_view)
    AutoCompleteTextView autoCompleteTextView;
    @Bind(R.id.activity_edit_multi_auto_complete_text_view)
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    @Bind(R.id.activity_edit_spinner)
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);

        editText.setText("Test~");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_dropdown_item_1line);
        autoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }
}
