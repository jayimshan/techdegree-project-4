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
import com.affogatostudios.whichanimalareyou.model.Page;

public class QuestionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView questionTextView;
    private Page page;
    private Spinner spinner;
    private String[] choices;
    private int currentQuestion;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionTextView = findViewById(R.id.questionTextView);
        page = new Page();
        spinner = findViewById(R.id.spinner1);
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
                score += 1;
                nextQuestion();
                break;
            case "AGREE":
                score += 2;
                nextQuestion();
                break;
            case "NEUTRAL":
                score += 3;
                nextQuestion();
                break;
            case "DISAGREE":
                score += 4;
                nextQuestion();
                break;
            case "STRONGLY DISAGREE":
                score += 5;
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
                Intent intent = new Intent(this, AnimalActivity.class);
                intent.putExtra("score", score);
                startActivity(intent);
                break;
        }
        Toast.makeText(this, Integer.toString(score), Toast.LENGTH_SHORT).show();
    }

    private void loadQuestion(int question) {
        // load correct questions and answer options
        questionTextView.setText(page.getQuestion(question).getQuestionId());
    }
}
