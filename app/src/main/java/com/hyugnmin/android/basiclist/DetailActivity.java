package com.hyugnmin.android.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textNo2, textDay2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textNo2 = (TextView) findViewById(R.id.textNo2);
        textDay2 = (TextView) findViewById(R.id.textDay2);
        //1.리스트에서 넘어온 인텐트를 꺼낸다
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        //2.넘어온 인텐트에서 특정 값을 타입에 맞춰서 꺼낸다
        int no = bundle.getInt("no");
        String day = bundle.getString("day");
        //3. 꺼낸 값을 위젯에 세팅한다.
        textNo2.setText(no+"");
        textDay2.setText(day);
    }
}
