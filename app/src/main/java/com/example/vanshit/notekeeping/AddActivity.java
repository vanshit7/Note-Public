package com.example.vanshit.notekeeping;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.Random;

public class AddActivity extends AppCompatActivity {

    EditText e1;
    String col = "#90ceb6";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        backcolor();
        save();
    }
    public void save(){
        Button butsave = (Button)findViewById(R.id.button);
        butsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
            // TODO Add extras or a data URI to this intent as appropriate.
                resultIntent.putExtra("key1",e1.getText().toString());
                resultIntent.putExtra("key2", col);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
    /*public void addnote(){
        MainActivity main = new MainActivity(e1.getText().toString(),col);

    }*/
    public void backcolor()
    {
        Random co = new Random();
        e1= (EditText)findViewById(R.id.editText);
        int picked = co.nextInt(5)+1;
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.r1);

        if(picked==1)
        {
            rl.setBackgroundColor(Color.parseColor("#1db06c"));
            e1.setBackgroundColor(Color.parseColor("#90ceb6"));
            col = "#90ceb6";
        }
        else if(picked==2)
        {
            rl.setBackgroundColor(Color.parseColor("#2f52ce"));
            e1.setBackgroundColor(Color.parseColor("#90aace"));
            col = "#90aace";
        }
        else if(picked ==3)
        {
            rl.setBackgroundColor(Color.parseColor("#c2df1a"));
            e1.setBackgroundColor(Color.parseColor("#c5ce90"));
            col = "#c5ce90";
        }
        else if(picked==4)
        {
            rl.setBackgroundColor(Color.parseColor("#df621a"));
            e1.setBackgroundColor(Color.parseColor("#cead90"));
            col = "#cead90";
        }
        else
        {
            rl.setBackgroundColor(Color.parseColor("#b01d7a"));
            e1.setBackgroundColor(Color.parseColor("#ce90ba"));
            col = "#ce90ba";
        }
    }
}
