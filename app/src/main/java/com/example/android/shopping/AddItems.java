package com.example.android.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddItems extends AppCompatActivity {

    public static final String ITEMS ="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);


    }


    public void saveData(View view) {
        Button selected=(Button)view;
        String data=selected.getText().toString();
        Intent intent =new Intent();
        intent.putExtra(ITEMS,data);
        setResult(RESULT_OK,intent);
        finish();

    }

}
