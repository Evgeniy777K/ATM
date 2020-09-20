package com.example.project77777;

import android.os.StrictMode;

import androidx.appcompat.app.AppCompatActivity;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Translator extends AppCompatActivity {

   private String translatedText;
        Translate translate;


    public void getTranslateService() {

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
    }

    public void translate(List<String> x) {

        //Get input text to be translated:

        int a = x.size();

        for (int i = 0; i < a; i++)
        {
            Translation translation = translate.translate(x.get(i), Translate.TranslateOption.targetLanguage("ru"), Translate.TranslateOption.model("base"));
            translatedText = translation.getTranslatedText();
            x.add(translatedText);
        }


    }

}




