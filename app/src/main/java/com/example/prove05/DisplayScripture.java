package com.example.prove05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScripture extends AppCompatActivity {

    private static final String TAG = "Display Scripture";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        // Get the Intent that started this activity and extract the string
        Bundle bundle = getIntent().getExtras();

        String scriptureBook = bundle.getString("book");
        String scriptureChapter = bundle.getString("chapter");
        String scriptureVerse = bundle.getString("verse");

        String message = scriptureBook + " " + scriptureChapter + ":" + scriptureVerse;
        Log.d(TAG, "Received intent with " + message);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView5);
        textView.setText(message);
    }

    /** Called when the user taps the Save button */
    public void saveScripture(View view) {
        Bundle bundle = getIntent().getExtras();

        String scriptureBook = bundle.getString("book");
        String scriptureChapter = bundle.getString("chapter");
        String scriptureVerse = bundle.getString("verse");

        SharedPreferences sharedPref = this.getSharedPreferences("scripture", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("book", scriptureBook);
        editor.putString("chapter", scriptureChapter);
        editor.putString("verse", scriptureVerse);
        editor.apply();
        Toast.makeText(this, "Success! Scripture Saved", Toast.LENGTH_LONG).show();


    }
}