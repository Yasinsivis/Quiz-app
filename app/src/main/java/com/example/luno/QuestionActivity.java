package com.example.luno;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    RadioButton r1, r2, r3, r4;
    TextView point, clue, EngWord;
    int currentQuesitonIndex = 0;
    int testIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question);

        r1 = findViewById(R.id.answer1RadioButton);
        r2 = findViewById(R.id.answer2RadioButton);
        r3 = findViewById(R.id.answer3RadioButton);
        r4 = findViewById(R.id.answer4RadioButton);

        point = findViewById(R.id.Point);
        clue = findViewById(R.id.Hint);
        EngWord = findViewById(R.id.questionTextView);

        testIndex = getIntent().getIntExtra("Index", -1);
        Log.d("QUESTiıonj", "Rreceived  index:" + testIndex);

        setNewQuestion();
    }
    public void setNewQuestion() {
        Test firstTest = APP.TestList.get(testIndex);
        List<Question> questionList = firstTest.getQuestionList();
        if (currentQuesitonIndex < questionList.size()) {
            String questionText = questionList.get(currentQuesitonIndex).getEnglishWord().getName();
            String optionA = questionList.get(currentQuesitonIndex).getAnswer_1().getName();
            String optionB = questionList.get(currentQuesitonIndex).getAnswer_2().getName();
            String optionC = questionList.get(currentQuesitonIndex).getAnswer_3().getName();
            String optionD = questionList.get(currentQuesitonIndex).getAnswer_4().getName();
            String Clue = questionList.get(currentQuesitonIndex).getClue();

            int Point = questionList.get(currentQuesitonIndex).getPoint();
            String pointText = String.valueOf(Point);

            EngWord.setText(questionText);
            point.setText(pointText);
            r1.setText(optionA);
            r2.setText(optionB);
            r3.setText(optionC);
            r4.setText(optionD);
            clue.setText(Clue);
        }
        currentQuesitonIndex++;
    }

    //Sonraki soru buttonuna tıklandığında yapılan işlemler
    public void EnterButton(View view) {
        int Index = getIntent().getIntExtra("Index", -1);
        Log.d("QUESTiıonj", "Rreceived  index:" + Index);
        setNewQuestion();
    }
    public void ExitButton(View view){
        Intent Undo = new Intent(QuestionActivity.this,HomeActivity.class);
        startActivity(Undo);
    }

}