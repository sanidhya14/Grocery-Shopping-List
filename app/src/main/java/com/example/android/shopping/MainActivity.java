package com.example.android.shopping;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int GET_DATA = 4;
    private EditText searchEditText;
   private TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=findViewById(R.id.textView4);
        searchEditText=findViewById(R.id.editText_search);

    }

    public void launchAddItems(View view) {
        Intent intent=new Intent(this,AddItems.class);
        startActivityForResult(intent,GET_DATA);
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data1){
        super.onActivityResult(requestCode,resultCode,data1);


        if(requestCode==GET_DATA){
            if(resultCode==RESULT_OK){
                String apple;
                 apple=data1.getStringExtra(AddItems.ITEMS);
                text1.setText(apple);
                text1.setVisibility(View.VISIBLE);
            }
        }
    }

    public void storeSearch(View view) {
        String url=searchEditText.getText().toString();
        Uri maps=Uri.parse("geo:0,0?q="+url);
        Intent intent=new Intent(Intent.ACTION_VIEW,maps);

        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }
        else
            Log.d("intents","error");
    }
}

