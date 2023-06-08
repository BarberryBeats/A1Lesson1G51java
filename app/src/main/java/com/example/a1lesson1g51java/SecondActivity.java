package com.example.a1lesson1g51java;

import static com.example.a1lesson1g51java.MainActivity.USERNAME_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewKt;
import android.widget.TextView;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.tv_result);

        String result = getIntent().getStringExtra(USERNAME_KEY);

        textView.setText(result);

    }
}