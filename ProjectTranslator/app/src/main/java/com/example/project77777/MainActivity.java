package com.example.project77777;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity
        {
    Button btnActTwo;

    private EditText tense;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<VerbRow> verbs = databaseAccess.getVerbs();
        databaseAccess.close();

// Создаем обьект, и отслеживание нажатий, жестов

        tense =  findViewById(R.id.editTextTime);
    }

    public void nextActivity(View view) {

        Intent intent = new Intent(this, Main2Activity.class);

        intent.putExtra("name", tense.getText().toString());
        startActivity(intent);
    }
}

