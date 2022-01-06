package com.example.intentinandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button getPhNo,call;
    private TextView renderNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPhNo = findViewById(R.id.getPhNo);
        renderNum = findViewById(R.id.renderNum);
        call = findViewById(R.id.call);

        if(renderNum.getText().toString() == null)
        {
            call.setEnabled(true);

        }


        getPhNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ContactActivity.class);
                startActivityForResult(intent,200);
            }
        });



        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + renderNum.getText().toString();


                callIntent.setData(Uri.parse(p));
                startActivity(callIntent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 200 && resultCode == RESULT_OK)
        {
            String num  = data.getStringExtra("number");
            Log.e("msg",num);
            renderNum.setText(num);

        }

    }
}