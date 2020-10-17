package com.example.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_MESSAGE3 = "com.example.myfirstapp.MESSAGE";
    private static final String TAG = "Main Activity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        EditText book = (EditText) findViewById(R.id.book);
        EditText chapter = (EditText) findViewById(R.id.chapter);
        EditText verse = (EditText) findViewById(R.id.verse);
        String scriptureBook = book.getText().toString();
        String scriptureChapter = chapter.getText().toString();
        String scriptureVerse = verse.getText().toString();
        String message = scriptureBook + " " + scriptureChapter + ":" + scriptureVerse;
        Bundle bundle = new Bundle();
        bundle.putString("book", scriptureBook);
        bundle.putString("chapter", scriptureChapter);
        bundle.putString("verse", scriptureVerse);
        Log.d(TAG, "About to create intent with " + message);

        Intent intent = new Intent(this, DisplayScripture.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    /** Called when the user taps the Send button */
    public void loadScripture(View view) {
        EditText books = (EditText) findViewById(R.id.book);
        EditText chapter = (EditText) findViewById(R.id.chapter);
        EditText verse = (EditText) findViewById(R.id.verse);

        SharedPreferences sharedPref = this.getSharedPreferences("scripture", Context.MODE_PRIVATE);
        String b = sharedPref.getString("book", "none");
        String c = sharedPref.getString("chapter", "none");
        String v = sharedPref.getString("verse", "none");
        books.setText(b);
        chapter.setText(c);
        verse.setText(v);
    }
}