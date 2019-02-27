package com.example.android.shopping;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int GET_DATA = 4;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            text1.setText(savedInstanceState.getString("text1"));
            text2.setText(savedInstanceState.getString("text2"));
            text3.setText(savedInstanceState.getString("text3"));
            text4.setText(savedInstanceState.getString("text4"));
            text5.setText(savedInstanceState.getString("text5"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.textView4);
        text2 = findViewById(R.id.textView5);
        text3 = findViewById(R.id.textView6);
        text4 = findViewById(R.id.textView7);
        text5 = findViewById(R.id.textView8);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text1", text1.getText().toString());
        outState.putString("text2", text2.getText().toString());
        outState.putString("text3", text3.getText().toString());
        outState.putString("text4", text4.getText().toString());
        outState.putString("text5", text5.getText().toString());
    }

    public void launchAddItems(View view) {
        Intent intent = new Intent(this, AddItems.class);
        startActivityForResult(intent, GET_DATA);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data1) {
        super.onActivityResult(requestCode, resultCode, data1);


        if (requestCode == GET_DATA) {
            if (resultCode == RESULT_OK) {
                String apple;

                apple = data1.getStringExtra(AddItems.ITEMS);

                if (text1.getVisibility()==View.INVISIBLE) {
                    text1.setText(apple);
                    text1.setVisibility(View.VISIBLE);
                }
               else if (text2.getVisibility()==View.INVISIBLE) {
                    text2.setText(apple);
                    text2.setVisibility(View.VISIBLE);
                } else if (text3.getVisibility()==View.INVISIBLE) {
                    text3.setText(apple);
                    text3.setVisibility(View.VISIBLE);
                } else if (text4.getVisibility()==View.INVISIBLE) {
                    text4.setText(apple);
                    text4.setVisibility(View.VISIBLE);
                } else if (text5.getVisibility()==View.INVISIBLE) {
                    text5.setText(apple);
                    text5.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void storeSearch(View view) {
        Uri maps = Uri.parse("geo:0,0?q=" + "grocery stores near me");
        Intent intent = new Intent(Intent.ACTION_VIEW, maps);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else
            Log.d("intents", "error");
    }
}

