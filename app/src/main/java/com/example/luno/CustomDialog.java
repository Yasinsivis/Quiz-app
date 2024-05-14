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
}


