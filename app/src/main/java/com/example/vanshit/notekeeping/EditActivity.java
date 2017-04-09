package com.example.vanshit.notekeeping;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText edit;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        intent = getIntent();
        edit = (EditText)findViewById(R.id.editText);
        edit.setText(intent.getStringExtra("key1"));
        backgnd();
        save();
        delete();
    }
    public void backgnd(){

        //edit.setBackgroundColor(Color.parseColor(intent.getStringExtra("key3")));
    }
    public void delete(){
        Button butsave = (Button)findViewById(R.id.button2);
        butsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                // TODO Add extras or a data URI to this intent as appropriate.
                resultIntent.putExtra("key1",edit.getText().toString());
                resultIntent.putExtra("pos",intent.getIntExtra("pos",1));
                setResult(2, resultIntent);
                finish();
            }
        });
    }
    public void save(){
        Button butsave = (Button)findViewById(R.id.ebutton);
        butsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                // TODO Add extras or a data URI to this intent as appropriate.
                resultIntent.putExtra("key1",edit.getText().toString());
               // resultIntent.putExtra("key2",Color.parseColor(intent.getStringExtra("key3")) );
                resultIntent.putExtra("pos",intent.getIntExtra("pos", 1));
                setResult(1, resultIntent);
                finish();
            }
        });
    }
}
