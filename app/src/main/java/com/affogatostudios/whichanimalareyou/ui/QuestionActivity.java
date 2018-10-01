package com.affogatostudios.whichanimalareyou.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.affogatostudios.whichanimalareyou.R;
import com.affogatostudios.whichanimalareyou.model.Question;

public class QuestionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView questionTextView;
    private Spinner spinner;
    private Question[] questions;
    private String[] choices;
    private int currentQuestion;
    private int score;
    private String caption;
    private Intent animalActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        animalActivityIntent = new Intent(this, AnimalActivity.class);

        questionTextView = findViewById(R.id.questionTextView);
        spinner = findViewById(R.id.spinner1);
        questions = new Question[8];

        questions[0] = new Question(R.string.question1);
        questions[1] = new Question(R.string.question2);
        questions[2] = new Question(R.string.question3);
        questions[3] = new Question(R.string.question4);
        questions[4] = new Question(R.string.question5);
        questions[5] = new Question(R.string.question6);
        questions[6] = new Question(R.string.question7);
        questions[7] = new Question(R.string.question8);
        choices = new String[] {
                "",
                "STRONGLY AGREE",
                "AGREE",
                "NEUTRAL",
                "DISAGREE",
                "STRONGLY DISAGREE"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, choices);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(0);
        currentQuestion = 0;
        score = 0;
        caption = intent.getStringExtra("caption");

        // load initial question
        loadQuestion(currentQuestion);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        switch (text) {
            case "":
                break;
            case "STRONGLY AGREE":
                score += 0;
                nextQuestion();
                break;
            case "AGREE":
                score += 3;
                nextQuestion();
                break;
            case "NEUTRAL":
                score += 5;
                nextQuestion();
                break;
            case "DISAGREE":
                score += 7;
                nextQuestion();
                break;
            case "STRONGLY DISAGREE":
                score += 9;
                nextQuestion();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void nextQuestion() {
        switch (currentQuestion) {
            case 0:
                spinner.setSelection(0);
                currentQuestion = 1;
                loadQuestion(currentQuestion);
                break;
            case 1:
                spinner.setSelection(0);
                currentQuestion = 2;
                loadQuestion(currentQuestion);
                break;
            case 2:
                spinner.setSelection(0);
                currentQuestion = 3;
                loadQuestion(currentQuestion);
                break;
            case 3:
                spinner.setSelection(0);
                currentQuestion = 4;
                loadQuestion(currentQuestion);
                break;
            case 4:
                spinner.setSelection(0);
                currentQuestion = 5;
                loadQuestion(currentQuestion);
                break;
            case 5:
                spinner.setSelection(0);
                currentQuestion = 6;
                loadQuestion(currentQuestion);
                break;
            case 6:
                spinner.setSelection(0);
                currentQuestion = 7;
                loadQuestion(currentQuestion);
                break;
            case 7:
                animalActivityIntent.putExtra("score", score);
                animalActivityIntent.putExtra("caption", caption);
                //intent.putExtra("score", score);
                //intent.putExtra("caption", caption);
                startActivity(animalActivityIntent);
                break;
        }
        //Toast.makeText(this, Integer.toString(score), Toast.LENGTH_SHORT).show();
    }

    private void loadQuestion(int question) {
        // load correct questions and answer options
        questionTextView.setText(questions[question].getQuestionId());
    }
}
