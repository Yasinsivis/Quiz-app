package com.example.luno;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {
    private  TextView text, Hint, Point;
    private RadioButton rb1, rb2, rb3, rb4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question);

        text = findViewById(R.id.questionTextView);
        rb1 = findViewById(R.id.answer1RadioButton);
        rb2=findViewById(R.id.answer2RadioButton);
        rb3=findViewById(R.id.answer3RadioButton);
        rb4=findViewById(R.id.answer4RadioButton);
        Hint = findViewById(R.id.Hint);
    }

}