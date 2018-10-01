package com.affogatostudios.whichanimalareyou.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.affogatostudios.whichanimalareyou.R;
import com.affogatostudios.whichanimalareyou.model.Animal;

public class AnimalActivity extends AppCompatActivity {

    private TextView animalTextView;
    private TextView captionTextView;
    private ImageView animalView;
    private Animal[] animals;
    private static final String TAG = AnimalActivity.class.getSimpleName();
    private String caption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        animalTextView = findViewById(R.id.animalTextView);
        captionTextView = findViewById(R.id.captionTextView);
        animalView = findViewById(R.id.animalView);
        animals = new Animal[10];
        Resources res = getResources();
        animals[0] = new Animal(R.drawable.cat, res.getString(R.string.cat));
        animals[1] = new Animal(R.drawable.dog, res.getString(R.string.dog));
        animals[2] = new Animal(R.drawable.dolphin, res.getString(R.string.dolphin));
        animals[3] = new Animal(R.drawable.elephant, res.getString(R.string.elephant));
        animals[4] = new Animal(R.drawable.monkey, res.getString(R.string.monkey));
        animals[5] = new Animal(R.drawable.rabbit, res.getString(R.string.rabbit));
        animals[6] = new Animal(R.drawable.red_panda, res.getString(R.string.red_panda));
        animals[7] = new Animal(R.drawable.snake, res.getString(R.string.snake));
        animals[8] = new Animal(R.drawable.snow_leopard, res.getString(R.string.snow_leopard));
        animals[9] = new Animal(R.drawable.tiger, res.getString(R.string.tiger));

        Intent intent = getIntent();
        intent.getStringExtra("score");
        caption = intent.getStringExtra("caption");
        captionTextView.setText(caption);
        checkScore(intent.getIntExtra("score", 0));
    }

    private void checkScore(int score) {
        Drawable image;
        if (score >= 0 && score <= 8) {
            animalTextView.setText(animals[4].getAnimalName());
            captionTextView.setX(200);
            captionTextView.setY(200);
            image = ContextCompat.getDrawable(this, animals[4].getImageId());
            animalView.setImageDrawable(image);
            toastAnimal(animals[4].getAnimalName());
        } else if (score >= 9 && score <= 16) {
            animalTextView.setText(animals[1].getAnimalName());
            captionTextView.setX(-50);
            captionTextView.setY(-50);
            image = ContextCompat.getDrawable(this, animals[1].getImageId());
            animalView.setImageDrawable(image);
            toastAnimal(animals[1].getAnimalName());
        } else if (score >= 17 && score <= 24) {
            animalTextView.setText(animals[3].getAnimalName());
            captionTextView.setX(-150);
            captionTextView.setY(-50);
            image = ContextCompat.getDrawable(this, animals[3].getImageId());
            animalView.setImageDrawable(image);
            toastAnimal(animals[3].getAnimalName());
        } else if (score >= 25 && score <= 30) {
            animalTextView.setText(animals[9].getAnimalName());
            captionTextView.setX(200);
            captionTextView.setY(150);
            image = ContextCompat.getDrawable(this, animals[9].getImageId());
            animalView.setImageDrawable(image);
            toastAnimal(animals[9].getAnimalName());
        } else if (score >= 31 && score <= 36) {
            animalTextView.setText(animals[7].getAnimalName());
            captionTextView.setX(170);
            captionTextView.setY(200);
            image = ContextCompat.getDrawable(this, animals[7].getImageId());
            animalView.setImageDrawable(image);
            toastAnimal(animals[7].getAnimalName());
        } else if (score >= 37 && score <= 44) {
            animalTextView.setText(animals[0].getAnimalName());
            captionTextView.setX(100);
            captionTextView.setY(170);
            image = ContextCompat.getDrawable(this, animals[0].getImageId());
            animalView.setImageDrawable(image);
            toastAnimal(animals[0].getAnimalName());
        } else if (score >= 45 && score <= 52) {
            animalTextView.setText(animals[8].getAnimalName());
            captionTextView.setX(200);
            captionTextView.setY(400);
            image = ContextCompat.getDrawable(this, animals[8].getImageId());
            animalView.setImageDrawable(image);
            toastAnimal(animals[8].getAnimalName());
        } else if (score >= 53 && score <= 60) {
            animalTextView.setText(animals[5].getAnimalName());
            captionTextView.setX(200);
            captionTextView.setY(400);
            image = ContextCompat.getDrawable(this, animals[5].getImageId());
            animalView.setImageDrawable(image);
            toastAnimal(animals[5].getAnimalName());
        } else if (score >= 61 && score <= 68) {
            animalTextView.setText(animals[6].getAnimalName());
            captionTextView.setX(100);
            captionTextView.setY(250);
            image = ContextCompat.getDrawable(this, animals[6].getImageId());
            animalView.setImageDrawable(image);
            toastAnimal(animals[6].getAnimalName());
        } else if (score >= 69 && score <= 72) {
            animalTextView.setText(animals[2].getAnimalName());
            captionTextView.setX(170);
            captionTextView.setY(-170);
            image = ContextCompat.getDrawable(this, animals[2].getImageId());
            animalView.setImageDrawable(image);
            toastAnimal(animals[2].getAnimalName());
        }
    }

    public void toastAnimal(String animal) {
        Toast.makeText(this, "You're a " + animal, Toast.LENGTH_SHORT).show();
    }
}
