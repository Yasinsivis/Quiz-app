package com.example.luno;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question);

        int Index = getIntent().getIntExtra("Index", -1);
        Log.d("QUESTiıonj","Rreceived  index:" + Index);
        int index = APP.TestList.indexOf(0);
        Log.d("Question","Index of 0 in TextList : "+index);
        Question question = new Question();
        RadioButton r1=findViewById(R.id.answer1RadioButton);


        switch (Index){
            case 0:
                Toast.makeText(this, "DOG butonuna tıklandı", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "DOG butonuna tıklandı", Toast.LENGTH_SHORT).show();
                break;
        }


    }

}