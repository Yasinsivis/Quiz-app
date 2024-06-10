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


        int Index = getIntent().getIntExtra("Index", -1);
        Log.d("QUESTiıonj", "Rreceived  index:" + Index);

        switch (Index) {
            case 0:
                Test firstTest = APP.TestList.get(0);
                List<Question> questionList = firstTest.getQuestionList();
                for (Question question1 : questionList) {
                    String questionText = questionList.get(0).getEnglishWord().getName();
                    String optionA = questionList.get(0).getAnswer_1().getName();
                    String optionB = questionList.get(0).getAnswer_2().getName();
                    String optionC = questionList.get(0).getAnswer_3().getName();
                    String optionD = questionList.get(0).getAnswer_4().getName();
                    int Point = questionList.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionList.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 1:
                Test secondTest = APP.TestList.get(1);
                List<Question> questionListTwo = secondTest.getQuestionList();
                for (Question question1 : questionListTwo) {
                    String questionText = questionListTwo.get(0).getEnglishWord().getName();
                    String optionA = questionListTwo.get(0).getAnswer_1().getName();
                    String optionB = questionListTwo.get(0).getAnswer_2().getName();
                    String optionC = questionListTwo.get(0).getAnswer_3().getName();
                    String optionD = questionListTwo.get(0).getAnswer_4().getName();
                    int Point = questionListTwo.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListTwo.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 2:
                Test thirdTest = APP.TestList.get(2);
                List<Question> questionListThird = thirdTest.getQuestionList();
                for (Question question1 : questionListThird) {
                    String questionText = questionListThird.get(0).getEnglishWord().getName();
                    String optionA = questionListThird.get(0).getAnswer_1().getName();
                    String optionB = questionListThird.get(0).getAnswer_2().getName();
                    String optionC = questionListThird.get(0).getAnswer_3().getName();
                    String optionD = questionListThird.get(0).getAnswer_4().getName();
                    int Point = questionListThird.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListThird.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 3:
                Test fourthTest = APP.TestList.get(3);
                List<Question> questionListFourth = fourthTest.getQuestionList();
                for (Question question1 : questionListFourth){
                    String questionText = questionListFourth.get(0).getEnglishWord().getName();
                    String optionA = questionListFourth.get(0).getAnswer_1().getName();
                    String optionB = questionListFourth.get(0).getAnswer_2().getName();
                    String optionC = questionListFourth.get(0).getAnswer_3().getName();
                    String optionD = questionListFourth.get(0).getAnswer_4().getName();
                    int Point = questionListFourth.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListFourth.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 4:
                Test fifthTest = APP.TestList.get(4);
                List<Question> questionListFifth = fifthTest.getQuestionList();
                for (Question question1 : questionListFifth) {
                    String questionText = questionListFifth.get(0).getEnglishWord().getName();
                    String optionA = questionListFifth.get(0).getAnswer_1().getName();
                    String optionB = questionListFifth.get(0).getAnswer_2().getName();
                    String optionC = questionListFifth.get(0).getAnswer_3().getName();
                    String optionD = questionListFifth.get(0).getAnswer_4().getName();
                    int Point = questionListFifth.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListFifth.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);

                }
                break;
            case 5:
                Test sixthTest = APP.TestList.get(5);
                List<Question> questionListSixth = sixthTest.getQuestionList();
                for (Question question1 : questionListSixth) {
                    String questionText = questionListSixth.get(0).getEnglishWord().getName();
                    String optionA = questionListSixth.get(0).getAnswer_1().getName();
                    String optionB = questionListSixth.get(0).getAnswer_2().getName();
                    String optionC = questionListSixth.get(0).getAnswer_3().getName();
                    String optionD = questionListSixth.get(0).getAnswer_4().getName();
                    int Point = questionListSixth.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListSixth.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 6:
                Test seventhTest = APP.TestList.get(6);
                List<Question> questionListSeventh = seventhTest.getQuestionList();
                for (Question question1 : questionListSeventh) {
                    String questionText = questionListSeventh.get(0).getEnglishWord().getName();
                    String optionA = questionListSeventh.get(0).getAnswer_1().getName();
                    String optionB = questionListSeventh.get(0).getAnswer_2().getName();
                    String optionC = questionListSeventh.get(0).getAnswer_3().getName();
                    String optionD = questionListSeventh.get(0).getAnswer_4().getName();
                    int Point = questionListSeventh.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListSeventh.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 7:
                Test eighthTest = APP.TestList.get(7);
                List<Question> questionListEighth = eighthTest.getQuestionList();
                for (Question question1 : questionListEighth) {
                    String questionText = questionListEighth.get(0).getEnglishWord().getName();
                    String optionA = questionListEighth.get(0).getAnswer_1().getName();
                    String optionB = questionListEighth.get(0).getAnswer_2().getName();
                    String optionC = questionListEighth.get(0).getAnswer_3().getName();
                    String optionD = questionListEighth.get(0).getAnswer_4().getName();
                    int Point = questionListEighth.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListEighth.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 8:
                Test ninthTest = APP.TestList.get(8);
                List<Question> questionListNinth = ninthTest.getQuestionList();
                for (Question question1 : questionListNinth) {
                    String questionText = questionListNinth.get(0).getEnglishWord().getName();
                    String optionA = questionListNinth.get(0).getAnswer_1().getName();
                    String optionB = questionListNinth.get(0).getAnswer_2().getName();
                    String optionC = questionListNinth.get(0).getAnswer_3().getName();
                    String optionD = questionListNinth.get(0).getAnswer_4().getName();
                    int Point = questionListNinth.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListNinth.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 9:
                Test tenthTest = APP.TestList.get(9);
                List<Question> questionListTenth = tenthTest.getQuestionList();
                for (Question question1 : questionListTenth) {
                    String questionText = questionListTenth.get(0).getEnglishWord().getName();
                    String optionA = questionListTenth.get(0).getAnswer_1().getName();
                    String optionB = questionListTenth.get(0).getAnswer_2().getName();
                    String optionC = questionListTenth.get(0).getAnswer_3().getName();
                    String optionD = questionListTenth.get(0).getAnswer_4().getName();
                    int Point = questionListTenth.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListTenth.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 10:
                Test eleventhTest = APP.TestList.get(10);
                List<Question> questionListEleventh = eleventhTest.getQuestionList();
                for (Question question1 : questionListEleventh) {
                    String questionText = questionListEleventh.get(0).getEnglishWord().getName();
                    String optionA = questionListEleventh.get(0).getAnswer_1().getName();
                    String optionB = questionListEleventh.get(0).getAnswer_2().getName();
                    String optionC = questionListEleventh.get(0).getAnswer_3().getName();
                    String optionD = questionListEleventh.get(0).getAnswer_4().getName();
                    int Point = questionListEleventh.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListEleventh.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 11:
                Test twelfthTest = APP.TestList.get(11);
                List<Question> questionListTwelfth = twelfthTest.getQuestionList();
                for (Question question1 : questionListTwelfth) {
                    String questionText = questionListTwelfth.get(0).getEnglishWord().getName();
                    String optionA = questionListTwelfth.get(0).getAnswer_1().getName();
                    String optionB = questionListTwelfth.get(0).getAnswer_2().getName();
                    String optionC = questionListTwelfth.get(0).getAnswer_3().getName();
                    String optionD = questionListTwelfth.get(0).getAnswer_4().getName();
                    int Point = questionListTwelfth.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListTwelfth.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 12:
                Test thirteenthTest = APP.TestList.get(12);
                List<Question> questionListThirteenth = thirteenthTest.getQuestionList();
                for (Question question1 : questionListThirteenth) {
                    String questionText = questionListThirteenth.get(0).getEnglishWord().getName();
                    String optionA = questionListThirteenth.get(0).getAnswer_1().getName();
                    String optionB = questionListThirteenth.get(0).getAnswer_2().getName();
                    String optionC = questionListThirteenth.get(0).getAnswer_3().getName();
                    String optionD = questionListThirteenth.get(0).getAnswer_4().getName();
                    int Point = questionListThirteenth.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListThirteenth.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 13:
                Test fourteenthTest = APP.TestList.get(13);
                List<Question> questionListFourteenth = fourteenthTest.getQuestionList();
                for (Question question1 : questionListFourteenth) {
                    String questionText = questionListFourteenth.get(0).getEnglishWord().getName();
                    String optionA = questionListFourteenth.get(0).getAnswer_1().getName();
                    String optionB = questionListFourteenth.get(0).getAnswer_2().getName();
                    String optionC = questionListFourteenth.get(0).getAnswer_3().getName();
                    String optionD = questionListFourteenth.get(0).getAnswer_4().getName();
                    int Point = questionListFourteenth.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListFourteenth.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;
            case 14:
                Test fifteenthTest = APP.TestList.get(14);
                List<Question> questionListFifteenth = fifteenthTest.getQuestionList();
                for (Question question1 : questionListFifteenth) {
                    String questionText = questionListFifteenth.get(0).getEnglishWord().getName();
                    String optionA = questionListFifteenth.get(0).getAnswer_1().getName();
                    String optionB = questionListFifteenth.get(0).getAnswer_2().getName();
                    String optionC = questionListFifteenth.get(0).getAnswer_3().getName();
                    String optionD = questionListFifteenth.get(0).getAnswer_4().getName();
                    int Point = questionListFifteenth.get(0).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListFifteenth.get(0).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }

                break;

        }


    }
   int currentQuesitonIndex = 1;
    //Sonraki soru buttonuna tıklandığında yapılan işlemler
    public void EnterButton(View view) {
        int Index = getIntent().getIntExtra("Index", -1);
        Log.d("QUESTiıonj", "Rreceived  index:" + Index);

        switch (Index) {
            case 0:
                Test firstTest = APP.TestList.get(0);
                List<Question> questionList = firstTest.getQuestionList();

                    if (currentQuesitonIndex < questionList.size()) {

                            String questionText = questionList.get(currentQuesitonIndex).getEnglishWord().getName();
                            String optionA = questionList.get(currentQuesitonIndex).getAnswer_1().getName();
                            String optionB = questionList.get(currentQuesitonIndex).getAnswer_2().getName();
                            String optionC = questionList.get(currentQuesitonIndex).getAnswer_3().getName();
                            String optionD = questionList.get(currentQuesitonIndex).getAnswer_4().getName();
                            int Point = questionList.get(currentQuesitonIndex).getPoint();
                            String pointText = String.valueOf(Point);
                            String Clue = questionList.get(currentQuesitonIndex).getClue();
                            EngWord.setText(questionText);
                            r1.setText(optionA);
                            r2.setText(optionB);
                            r3.setText(optionC);
                            r4.setText(optionD);
                            point.setText(pointText);
                            clue.setText(Clue);
                        }
                    currentQuesitonIndex++;


                break;
            case 1:
                Test secondTest = APP.TestList.get(1);
                List<Question> questionListTwo = secondTest.getQuestionList();
                if (currentQuesitonIndex < questionListTwo.size()) {
                    String questionText = questionListTwo.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListTwo.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListTwo.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListTwo.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListTwo.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListTwo.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListTwo.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
            case 2:
                Test thirdTest = APP.TestList.get(2);
                List<Question> questionListThird = thirdTest.getQuestionList();
                if (currentQuesitonIndex < questionListThird.size()) {
                    String questionText = questionListThird.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListThird.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListThird.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListThird.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListThird.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListThird.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListThird.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
            case 3:
                Test fourthTest = APP.TestList.get(3);
                List<Question> questionListFourth = fourthTest.getQuestionList();
                if (currentQuesitonIndex < questionListFourth.size()) {
                    String questionText = questionListFourth.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListFourth.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListFourth.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListFourth.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListFourth.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListFourth.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListFourth.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
            case 4:
                Test fifthTest = APP.TestList.get(4);
                List<Question> questionListFifth = fifthTest.getQuestionList();
                if (currentQuesitonIndex < questionListFifth.size()) {
                    String questionText = questionListFifth.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListFifth.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListFifth.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListFifth.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListFifth.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListFifth.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListFifth.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
            case 5:
                Test sixthTest = APP.TestList.get(5);
                List<Question> questionListSixth = sixthTest.getQuestionList();
                if (currentQuesitonIndex < questionListSixth.size()) {
                    String questionText = questionListSixth.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListSixth.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListSixth.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListSixth.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListSixth.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListSixth.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListSixth.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
            case 6:
                Test seventhTest = APP.TestList.get(6);
                List<Question> questionListSeventh = seventhTest.getQuestionList();
                if (currentQuesitonIndex < questionListSeventh.size()) {
                    String questionText = questionListSeventh.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListSeventh.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListSeventh.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListSeventh.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListSeventh.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListSeventh.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListSeventh.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
            case 7:
                Test eighthTest = APP.TestList.get(7);
                List<Question> questionListEighth = eighthTest.getQuestionList();
                if (currentQuesitonIndex < questionListEighth.size()) {
                    String questionText = questionListEighth.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListEighth.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListEighth.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListEighth.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListEighth.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListEighth.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListEighth.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
            case 8:
                Test ninthTest = APP.TestList.get(8);
                List<Question> questionListNinth = ninthTest.getQuestionList();
                if (currentQuesitonIndex < questionListNinth.size()) {
                    String questionText = questionListNinth.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListNinth.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListNinth.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListNinth.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListNinth.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListNinth.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListNinth.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
            case 9:
                Test tenthTest = APP.TestList.get(9);
                List<Question> questionListTenth = tenthTest.getQuestionList();
                if (currentQuesitonIndex < questionListTenth.size()) {
                    String questionText = questionListTenth.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListTenth.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListTenth.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListTenth.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListTenth.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListTenth.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListTenth.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
            case 10:
                Test eleventhTest = APP.TestList.get(10);
                List<Question> questionListEleventh = eleventhTest.getQuestionList();
                if (currentQuesitonIndex < questionListEleventh.size()) {
                    String questionText = questionListEleventh.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListEleventh.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListEleventh.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListEleventh.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListEleventh.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListEleventh.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListEleventh.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
            case 11:
                Test twelfthTest = APP.TestList.get(11);
                List<Question> questionListTwelfth = twelfthTest.getQuestionList();
                if (currentQuesitonIndex < questionListTwelfth.size()) {
                    String questionText = questionListTwelfth.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListTwelfth.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListTwelfth.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListTwelfth.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListTwelfth.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListTwelfth.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListTwelfth.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
            case 12:
                Test thirteenthTest = APP.TestList.get(12);
                List<Question> questionListThirteenth = thirteenthTest.getQuestionList();
                if (currentQuesitonIndex < questionListThirteenth.size()) {
                    String questionText = questionListThirteenth.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListThirteenth.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListThirteenth.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListThirteenth.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListThirteenth.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListThirteenth.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListThirteenth.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
                case 13:
                Test fourteenthTest = APP.TestList.get(13);
                List<Question> questionListFourteenth = fourteenthTest.getQuestionList();
                if (currentQuesitonIndex < questionListFourteenth.size()) {
                    String questionText = questionListFourteenth.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListFourteenth.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListFourteenth.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListFourteenth.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListFourteenth.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListFourteenth.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListFourteenth.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;
                case 14:
                Test fifteenthTest = APP.TestList.get(14);
                List<Question> questionListFifteenth = fifteenthTest.getQuestionList();
                if (currentQuesitonIndex < questionListFifteenth.size()) {
                    String questionText = questionListFifteenth.get(currentQuesitonIndex).getEnglishWord().getName();
                    String optionA = questionListFifteenth.get(currentQuesitonIndex).getAnswer_1().getName();
                    String optionB = questionListFifteenth.get(currentQuesitonIndex).getAnswer_2().getName();
                    String optionC = questionListFifteenth.get(currentQuesitonIndex).getAnswer_3().getName();
                    String optionD = questionListFifteenth.get(currentQuesitonIndex).getAnswer_4().getName();
                    int Point = questionListFifteenth.get(currentQuesitonIndex).getPoint();
                    String pointText = String.valueOf(Point);
                    String Clue = questionListFifteenth.get(currentQuesitonIndex).getClue();
                    EngWord.setText(questionText);
                    r1.setText(optionA);
                    r2.setText(optionB);
                    r3.setText(optionC);
                    r4.setText(optionD);
                    point.setText(pointText);
                    clue.setText(Clue);
                }
                currentQuesitonIndex++;
                break;


        }
    }
    public void ExitButton(View view){
        Intent Undo = new Intent(QuestionActivity.this,HomeActivity.class);
        startActivity(Undo);
    }

}