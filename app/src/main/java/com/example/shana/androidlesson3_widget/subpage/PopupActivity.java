package com.example.shana.androidlesson3_widget.subpage;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.os.Handler;

import com.example.shana.androidlesson3_widget.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by shana on 2015/12/10.
 */
public class PopupActivity extends Activity {
    static class PopupType{
        public static final int POPUP_TYPE_POPUP_WINDOWS = 0;
        public static final int POPUP_TYPE_DIALOG = 1;
        public static final int POPUP_TYPE_ALERT_DIALOG = 2;
        public static final int POPUP_TYPE_PROGRESS_DIALOG = 3;
        public static final int POPUP_TYPE_TOAST = 4;
    }

    @Bind(R.id.activity_popup_list_view)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        ButterKnife.bind(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getPopupTitleList());
        listView.setAdapter(adapter);
    }

    private List<String> getPopupTitleList() {
        int[] popupTypeList = {PopupType.POPUP_TYPE_POPUP_WINDOWS, PopupType.POPUP_TYPE_DIALOG,
                PopupType.POPUP_TYPE_ALERT_DIALOG, PopupType.POPUP_TYPE_PROGRESS_DIALOG, PopupType.POPUP_TYPE_TOAST};
        ArrayList<String> popupTitleList = new ArrayList<>();
        for (int type : popupTypeList) {
            popupTitleList.add(getTitleWithPopupType(type));
        }
        return popupTitleList;
    }

    private String getTitleWithPopupType(int popupType) {
        switch (popupType) {
            case PopupType.POPUP_TYPE_POPUP_WINDOWS:
                return "PopupWindow";
            case PopupType.POPUP_TYPE_DIALOG:
                return "Dialog";
            case PopupType.POPUP_TYPE_ALERT_DIALOG:
                return "AlertDialog";
            case PopupType.POPUP_TYPE_PROGRESS_DIALOG:
                return "ProgressDialog";
            case PopupType.POPUP_TYPE_TOAST:
                return "Toast";
        }
        throw new RuntimeException("Unknown PopupType");
    }

    @OnItemClick(R.id.activity_popup_list_view)
    void onItemClick(int position) {
        switch (position) {
            case PopupType.POPUP_TYPE_POPUP_WINDOWS:
                showPopupWindows();
                break;
            case PopupType.POPUP_TYPE_DIALOG:
                showDialog();
                break;
            case PopupType.POPUP_TYPE_ALERT_DIALOG:
                showAlertDialog();
                break;
            case PopupType.POPUP_TYPE_PROGRESS_DIALOG:
                showProgressDialog();
                break;
            case PopupType.POPUP_TYPE_TOAST:
                showToast();
                break;
        }
    }

    private Button getDismissButtonForView(View.OnClickListener listener){
        Button dismissButton = new Button(this);
        dismissButton.setText("Dismiss");
        dismissButton.setOnClickListener(listener);
        return dismissButton;
    }

    private void showPopupWindows() {
        final PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setContentView(getDismissButtonForView(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        }));
        popupWindow.setFocusable(true);
        popupWindow.setWidth((int) (200 * Resources.getSystem().getDisplayMetrics().density));
        popupWindow.setHeight((int) (100 * Resources.getSystem().getDisplayMetrics().density));
        popupWindow.showAtLocation(listView, Gravity.CENTER, 0, 0);
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Hi~ This is dialog title");
        dialog.setContentView(getDismissButtonForView(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        }));
        dialog.show();
    }

    private void showAlertDialog() {
        Builder builder = new Builder(this);
        builder.setTitle("Hi~ This is alert title");
        builder.setMessage("You can show message here.");
        builder.setPositiveButton("dismiss", null);
        builder.show();
    }

    private void showProgressDialog(){
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Progressing...", "Please wait until finish");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, 5000);
    }

    private void showToast() {
        Toast.makeText(this, "Toast show message here!!", Toast.LENGTH_SHORT).show();
    }
}
