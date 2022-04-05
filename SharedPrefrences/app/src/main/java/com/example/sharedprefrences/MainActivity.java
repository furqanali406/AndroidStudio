package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tw;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.edittext);
        tw = findViewById(R.id.textView);
        btn = findViewById(R.id.button);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textval = et.getText().toString();
                SharedPreferences sp = getSharedPreferences("Mypref",MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("name",textval);
                ed.apply();
                tw.setText(textval);
            }
        });

        SharedPreferences sp = getSharedPreferences("Mypref",MODE_PRIVATE);
        String editstring = sp.getString("name","no value");
        tw.setText(editstring);
    }
}