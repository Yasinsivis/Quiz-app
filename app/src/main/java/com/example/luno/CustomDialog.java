package com.example.luno;
import android.content.Context;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private String title;
    private String message;
    private TextView dialogTitle;
    private TextView dialogMessage;
    private Button buttonOk;

    public CustomDialog(Context context, String title, String message) {
        super(context);
        this.title = title;
        this.message = message;
    }

    public CustomDialog(Context context) {
        super(context);
        this.getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);

        dialogTitle = findViewById(R.id.dialog_title);
        dialogMessage = findViewById(R.id.dialog_message);
        buttonOk = findViewById(R.id.dialog_button_ok);
        dialogTitle.setText(title);
        dialogMessage.setText(message);

        buttonOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }

    public void showDialog() {
        this.show();
    }

    public void setBackGround(int id) {
        this.getWindow().setBackgroundDrawableResource(id);
    }

    public void setMessageTitleAndShow(String message, String title ) {
        this.title = title;
        this.message = message;
        this.show();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


