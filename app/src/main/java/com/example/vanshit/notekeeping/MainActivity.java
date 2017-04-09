package com.example.vanshit.notekeeping;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> arrayAdapter ;
    private ArrayList<String> arrayList ;
    private ListView listView ;
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
        listView = (ListView) findViewById(R.id.lv);
        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                int colorpos = position%5;
                if(colorpos==1) view.setBackgroundColor(Color.parseColor("#90ceb6"));
                else if(colorpos==2) view.setBackgroundColor(Color.parseColor("#90aace"));
                else if(colorpos==3) view.setBackgroundColor(Color.parseColor("#c5ce90"));
                else if(colorpos==4) view.setBackgroundColor(Color.parseColor("#cead90"));
                else view.setBackgroundColor(Color.parseColor("#ce90ba"));
                return view;
            }
        };
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(open);
    }
    public AdapterView.OnItemClickListener open = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent readmode = new Intent(MainActivity.this,EditActivity.class);
            // TODO Add extras or a data URI to this intent as appropriate.
            readmode.putExtra("key1", (String) listView.getItemAtPosition(position));
            readmode.putExtra("pos",position);
            setResult(Activity.RESULT_OK, readmode);
            startActivityForResult(readmode,2);

        }
    };

    public void list(String text,String color){
            arrayList.add(text);
        Toast.makeText(this,"Successfully Inserted",Toast.LENGTH_LONG).show();
            arrayAdapter.notifyDataSetChanged();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
                if (resultCode == Activity.RESULT_OK) {
                    // TODO Extract the data returned from the child Activity.
                    String ret1 = data.getStringExtra("key1");
                    String ret2 = data.getStringExtra("key2");
                    list(ret1, ret2);
                }
            }
        else if(requestCode == 2){
            if(resultCode == 1){
                String ret1 = data.getStringExtra("key1");
                int pos = data.getIntExtra("pos", 1);
                arrayList.remove(pos);
                arrayAdapter.notifyDataSetChanged();
                arrayList.add(pos, ret1);
                Toast.makeText(this,"Successfully Edited",Toast.LENGTH_LONG).show();
                arrayAdapter.notifyDataSetChanged();
            }
            else if(resultCode == 2){
                int pos = data.getIntExtra("pos",1);
                Toast.makeText(this,"Successfully Deleted",Toast.LENGTH_LONG).show();
                arrayList.remove(pos);
                arrayAdapter.notifyDataSetChanged();
            }
        }
        }
    /*public void add(String str, String color){
       // Intent saveexit = new Intent(MainActivity.this, MainActivity.class);
        //startActivity(saveexit);
        RelativeLayout r = (RelativeLayout)findViewById(R.id.rel);
        TextView newtv = new TextView(this);
        newtv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        newtv.setText(str);
        newtv.setBackgroundColor(Color.parseColor(color));
        r.addView(newtv);
    }*/
}
