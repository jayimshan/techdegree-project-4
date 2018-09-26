package com.affogatostudios.whichanimalareyou.model;

import com.affogatostudios.whichanimalareyou.R;

public class Page {

    private int imageId;
    private int textId;
    private Question[] questions;

    public Page(int imageId, int textId) {

        this.imageId = imageId;
        this.textId = textId;
        questions = new Question[8];

        questions[0] = new Question(R.string.question1);
        questions[1] = new Question(R.string.question2);
        questions[2] = new Question(R.string.question3);
        questions[3] = new Question(R.string.question4);
        questions[4] = new Question(R.string.question5);
        questions[5] = new Question(R.string.question6);
        questions[6] = new Question(R.string.question7);
        questions[7] = new Question(R.string.question8);
    }

    public Question getQuestion(int question) {
        return questions[question];
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }
}
