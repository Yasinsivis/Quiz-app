package com.example.luno;

public class Question {

    private int id;
    private Answer answer_1;
    private Answer answer_2;
    private Answer answer_3;
    private Answer answer_4;
    private Answer correctAnswer;
    private int point;
    private String clue;


    public Question() {
    }

    public Question(int id, Answer answer_1, Answer answer_2, Answer answer_3, Answer answer_4, Answer correctAnswer, int point, String clue) {
        this.id = id;
        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;
        this.answer_4 = answer_4;
        this.correctAnswer = correctAnswer;
        this.point = point;
        this.clue = clue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Answer getAnswer_1() {
        return answer_1;
    }

    public void setAnswer_1(Answer answer_1) {
        this.answer_1 = answer_1;
    }

    public Answer getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(Answer answer_2) {
        this.answer_2 = answer_2;
    }

    public Answer getAnswer_3() {
        return answer_3;
    }

    public void setAnswer_3(Answer answer_3) {
        this.answer_3 = answer_3;
    }

    public Answer getAnswer_4() {
        return answer_4;
    }

    public void setAnswer_4(Answer answer_4) {
        this.answer_4 = answer_4;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }
}
