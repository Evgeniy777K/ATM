package com.example.project77777;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        button1 = (Button) findViewById(R.id.button_Past_Time);
        button2 = (Button) findViewById(R.id.button_Present_Time);
        button3 = (Button) findViewById(R.id.button_Future_Time);
        button4 = (Button) findViewById(R.id.button_Imperative);
        button5 = (Button) findViewById(R.id.button_Infinitive);
        button6 = (Button) findViewById(R.id.button_Beinoni);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this, Main3Activity.class);
                Bundle b = new Bundle();
                b.putString("time", "PAST");
                b.putString("shoresh", getIntent().getStringExtra("name"));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this, Main3Activity.class);
                Bundle b = new Bundle();
                b.putString("time", "PRESENT");
                b.putString("shoresh", getIntent().getStringExtra("name"));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this, Main3Activity.class);
                Bundle b = new Bundle();
                b.putString("time", "FUTURE");
                b.putString("shoresh", getIntent().getStringExtra("name"));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this, Main3Activity.class);
                Bundle b = new Bundle();
                b.putString("time", "IMPERATIVE");
                b.putString("shoresh", getIntent().getStringExtra("name"));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this, Main3Activity.class);
                Bundle b = new Bundle();
                b.putString("time", "INFINITIVE");
                b.putString("shoresh", getIntent().getStringExtra("name"));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this, Main3Activity.class);
                Bundle b = new Bundle();
                b.putString("time", "BEINONI");
                b.putString("shoresh", getIntent().getStringExtra("name"));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
