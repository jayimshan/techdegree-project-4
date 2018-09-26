package com.affogatostudios.whichanimalareyou.model;

public class Question {

    private int questionId;

    public Question(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
