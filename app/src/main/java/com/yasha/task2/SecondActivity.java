package com.yasha.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = (Button) findViewById(R.id.buttonBack);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                EditText answer = findViewById(R.id.answer);
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("answer", answer.getText().toString());
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
        Bundle extra = getIntent().getExtras();
        if(extra != null){
            String value = extra.getString("question");
            TextView textView = (TextView) findViewById(R.id.question);
            textView.setText(value);
        }
    }
}