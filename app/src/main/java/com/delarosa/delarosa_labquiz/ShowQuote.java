package com.delarosa.delarosa_labquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowQuote extends AppCompatActivity {

    TextView tvOutput;
    SharedPreferences preferences;
    String quote, author;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_quote);

        tvOutput = (TextView) findViewById(R.id.tvOutput);
        btnBack = (Button) findViewById(R.id.btnBack);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        author = preferences.getString("author", "");
        quote = preferences.getString("quote", "");
        tvOutput.setText(author + " said... \n\n\n\"" + quote + "\"");
    }

    public void goToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
