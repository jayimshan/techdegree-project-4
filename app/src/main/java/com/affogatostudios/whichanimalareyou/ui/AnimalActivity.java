package com.affogatostudios.whichanimalareyou.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.affogatostudios.whichanimalareyou.R;

public class AnimalActivity extends AppCompatActivity {

    private TextView animalTextView;
    private ImageView animalView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        animalTextView = findViewById(R.id.animalTextView);
        animalView = findViewById(R.id.animalView);

        Intent intent = getIntent();
        intent.getStringExtra("score");
        checkScore(intent.getIntExtra("score", 0));
    }

    private void checkScore(int score) {
        if (score <= 8) {
            animalTextView.setText("Monkey");
            animalView.setImageDrawable(R.drawable.monkey);
        } else if (score >= 9 && score <= 12) {
            animalTextView.setText("Dog");
        } else if (score >= 13 && score <= 16) {
            animalTextView.setText("Elephant");
        } else if (score >= 17 && score <= 20) {
            animalTextView.setText("Tiger");
        } else if (score >= 21 && score <= 24) {
            animalTextView.setText("Snake");
        } else if (score >= 25 && score <= 28) {
            animalTextView.setText("Cat");
        } else if (score >= 29 && score <= 32) {
            animalTextView.setText("Snow Leopard");
        } else if (score >= 33 && score <= 36) {
            animalTextView.setText("Rabbit");
        } else if (score >= 37 && score <= 40) {
            animalTextView.setText("Dolphin");
        }
    }
}
