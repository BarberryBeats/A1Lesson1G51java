package com.example.a1lesson1g51java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnNextActivity;
    private Integer age = 18;
    public static final String USERNAME_KEY = "email";
    public static final int GET_PHOTO = 123;
    private ImageView imgPicture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNextActivity = findViewById(R.id.btn_next_activity);
        imgPicture = findViewById(R.id.img_picture);

        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createIntent();
            }
        });

    }
    private void createIntent(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, GET_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GET_PHOTO && resultCode == RESULT_OK && data != null) {
            Uri picture = data.getData();
            imgPicture.setImageURI(picture);
            Log.d("Ray", picture.toString());
        }
    }
}