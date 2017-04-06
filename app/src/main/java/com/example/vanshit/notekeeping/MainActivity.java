package com.example.vanshit.notekeeping;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /*public MainActivity(String a,String b) {
        this.a= a;
        this.b = b;
        add(a,b);
    }*/
    //private String a = "";
    //private String b = "";
    Button AddBut;
    public void init(){
        AddBut = (Button)findViewById(R.id.add);
        AddBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newact = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(newact, 1);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
                if (resultCode == Activity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    String ret1 = data.getStringExtra("key1");
                    String ret2 = data.getStringExtra("key2");
                    add(ret1, ret2);
                }
            }
        }
    public void add(String str, String color){
       // Intent saveexit = new Intent(MainActivity.this, MainActivity.class);
        //startActivity(saveexit);
        RelativeLayout r = (RelativeLayout)findViewById(R.id.rel);
        TextView newtv = new TextView(this);
        newtv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        newtv.setText(str);
        newtv.setBackgroundColor(Color.parseColor(color));
        r.addView(newtv);
    }
}
