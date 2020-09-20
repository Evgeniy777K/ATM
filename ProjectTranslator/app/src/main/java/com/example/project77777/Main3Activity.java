package com.example.project77777;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3Activity extends AppCompatActivity {
//    Context context=this;

    String shoresh;
    String time;
    List<VerbRow> verbs;
    long counter = 0;
    Translate translate;
    private String translatedText;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        shoresh = getIntent().getStringExtra("shoresh");
        time = getIntent().getStringExtra("time");

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        verbs = databaseAccess.getVerbs();
        databaseAccess.close();


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try (InputStream is = getResources().openRawResource(R.raw.credentials)) {

            //Get credentials:
            final GoogleCredentials myCredentials = GoogleCredentials.fromStream(is);

            //Set credentials and get translate service:
            TranslateOptions translateOptions = TranslateOptions.newBuilder().setCredentials(myCredentials).build();
            translate = translateOptions.getService();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        }

        List<String> results = new ArrayList<>();

        for (int i = 0; i < verbs.size(); i++) {
            VerbRow verb = verbs.get(i);
            counter++;
            // Log.d("rrr_l", verb.toString()+" , "+counter);
            //   results.add(verb.toString()+" , "+counter);
            if (verb.toString().equals(shoresh) && verb.getTense().equals(time)) {
                Log.d("rrr_l", verb.getLitso());
                Log.d("rrr_ch", verb.getChislo());

                results.add(verb.vocalized_inflection + "  " + verb.getMesto());
            }
        }

        int a = results.size();
        List<String> results1 = new ArrayList<>();
        for (int b = 0; b < a; b++)
        {
            Translation translation = translate.translate(results.get(b), Translate.TranslateOption.targetLanguage("ru"), Translate.TranslateOption.model("base"));
            translatedText = translation.getTranslatedText();
            results1.add(translatedText);
        }

        Map<String,String> map = new LinkedHashMap<String,String>();

        for (int i=0; i<results.size(); i++) {
            map.put(results.get(i), results1.get(i));
        }

        List<String> list = map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "-" + entry.getValue())
                .collect(Collectors.toList());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        }

}






