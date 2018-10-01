package com.affogatostudios.whichanimalareyou.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.affogatostudios.whichanimalareyou.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button startButton;
    private Button findOutButton;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        findOutButton = findViewById(R.id.findOutButton);
        textView = findViewById(R.id.introTextView);
        textView.setText(R.string.intro);
        editText = findViewById(R.id.captionEditText);
        editText.setVisibility(View.INVISIBLE);

        startButton.setVisibility(View.GONE);

        findOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(R.string.caption);
                startButton.setVisibility(View.VISIBLE);
                findOutButton.setVisibility(View.GONE);
                editText.setVisibility(View.VISIBLE);
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(editText)) {
                    Toast.makeText(MainActivity.this, "Please enter a caption", Toast.LENGTH_SHORT).show();
                } else {
                    startQuestionnaire(editText);
                }
            }
        });
    }

    public boolean isEmpty(EditText text) {
        if (text.getText().toString().trim().length() > 0) {
            return false;
        }
        return true;
    }

    private void startQuestionnaire(EditText text) {
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("caption", text.getText().toString());
        //Log.d(TAG, text.getText().toString());
        startActivity(intent);
    }
}
