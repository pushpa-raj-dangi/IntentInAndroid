package com.example.intentinandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {
private Button saveBtn;
private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        saveBtn  = findViewById(R.id.saveBtn);
        editText = findViewById(R.id.myInputText);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String number = editText.getText().toString();
                intent.putExtra("number",number);
                setResult(RESULT_OK,intent);

                finish();
            }
        });


    }


}