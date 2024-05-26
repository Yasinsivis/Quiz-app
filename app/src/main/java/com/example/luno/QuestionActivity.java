package com.example.luno;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuestionActivity extends AppCompatActivity {
    private OracleDatabaseHelper dbHelper;
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

        dbHelper = new OracleDatabaseHelper();

        fetchData();
    }
    private void fetchData() {

        ProcessResult result = dbHelper.fetchEnglishWordData();

        if(result.getResult()){
            Questions questions = result.getQuestion();
            if(questions != null){
               //
                rb1.setText(questions.getOptionA());
                rb2.setText(questions.getOptionB());
                rb3.setText(questions.getOptionC());
                rb4.setText(questions.getOptionD());
                Point.setText(questions.getPoints());
                Hint.setText(questions.getHint());

            }
        }else{
            String errorMessage = result.getMessage();
        }


    }
}