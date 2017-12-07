package com.delarosa.delarosa_labquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText etAuthor, etQuote;
    SharedPreferences preferences;
    Button btnSave, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnNext = (Button) findViewById(R.id.btnNext);

        etAuthor = (EditText) findViewById(R.id.etAuthor);
        etQuote = (EditText) findViewById(R.id.etQuote);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void saveShared(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("author",etAuthor.getText().toString());
        editor.putString("quote", etQuote.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved in Shared Preferences!", Toast.LENGTH_LONG).show();
    }

    public void goToShowQuote(View view){
        Intent intent = new Intent(this, ShowQuote.class);
        startActivity(intent);
    }
}
