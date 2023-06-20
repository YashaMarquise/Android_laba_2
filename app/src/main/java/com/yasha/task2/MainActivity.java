package com.yasha.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.buttonForward);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText question = findViewById(R.id.questionText);
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                intent.putExtra("question", question.getText().toString());
                startActivityForResult(intent, 100);
            }
        });
        }
        @Override
        protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 100 && resultCode == Activity.RESULT_OK)
            {
                 String result = data.getStringExtra("answer");
                 TextView editor = (TextView) findViewById(R.id.answerText);
                 editor.setText(result);
            }
        }

}