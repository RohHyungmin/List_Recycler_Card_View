package com.hyugnmin.android.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnList, btnHolder, btnRecycle, btnCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnList = (Button)findViewById(R.id.btnList);
        btnHolder = (Button)findViewById(R.id.btnHolder);
        btnRecycle = (Button)findViewById(R.id.btnRecycle);
        btnCard = (Button) findViewById(R.id.btnCard);

        btnList.setOnClickListener(this);
        btnHolder.setOnClickListener(this);
        btnRecycle.setOnClickListener(this);
        btnCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()) {
            case R.id.btnList:
                intent = new Intent(getApplicationContext(), ListviewActivity.class);
                break;
            case R.id.btnHolder:
                intent = new Intent(getApplicationContext(), ListviewholderActivity.class);
                break;
            case R.id.btnRecycle:
                intent = new Intent(getApplicationContext(), RecyclerviewActivity.class);
                break;
            case R.id.btnCard:
                intent = new Intent(getApplicationContext(), RecyclerCardActivity.class);
                break;
        }
        startActivity(intent);
    }
}
