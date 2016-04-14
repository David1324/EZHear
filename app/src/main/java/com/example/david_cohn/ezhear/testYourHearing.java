package com.example.david_cohn.ezhear;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.*;

import java.util.Locale;


public class testYourHearing extends ActionBarActivity {
    TextToSpeech textAudioUS;
//    ImageButton b1;
    String animal1;
    String animal2;
    String animal3;
    String animal4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_your_hearing);

        ArrayList animalsList = new ArrayList();
        animalsList.add("alligator");
        animalsList.add("cat");
        animalsList.add("cow");
        animalsList.add("dog");
        animalsList.add("donkey");
        animalsList.add("lamb");
        animalsList.add("lion");
        animalsList.add("monkey");
        animalsList.add("rabbit");



        ArrayList origList = animalsList;

        Collections.shuffle(animalsList);


        animal1 = (String)animalsList.get(0);
        animal2 = (String)animalsList.get(1);
        animal3 = (String)animalsList.get(2);
        animal4 = (String)animalsList.get(3);



        ImageButton button1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton button2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton button3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton button4 = (ImageButton) findViewById(R.id.imageButton4);
        int animalDrawingID1=getResources().getIdentifier(animal1, "drawable", getPackageName());
        int animalDrawingID2=getResources().getIdentifier(animal2, "drawable", getPackageName());
        int animalDrawingID3=getResources().getIdentifier(animal3, "drawable", getPackageName());
        int animalDrawingID4=getResources().getIdentifier(animal4, "drawable", getPackageName());
        button1.setBackgroundResource(animalDrawingID1);
        button2.setBackgroundResource(animalDrawingID2);
        button3.setBackgroundResource(animalDrawingID3);
        button4.setBackgroundResource(animalDrawingID4);

        textAudioUS=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textAudioUS.setLanguage(Locale.US);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textAudioUS.speak(animal1, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textAudioUS.speak(animal2, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textAudioUS.speak(animal3, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textAudioUS.speak(animal4, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_your_hearing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
