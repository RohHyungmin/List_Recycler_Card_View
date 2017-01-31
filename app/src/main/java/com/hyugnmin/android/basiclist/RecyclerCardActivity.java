package com.hyugnmin.android.basiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerCardActivity extends AppCompatActivity {
    ArrayList<User> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_card);

        Data data = new Data();
        datas = data.get();

        //뷰 가져오기
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView2);
        //2.아답터 생성하기
        CardAdapter ca = new CardAdapter(datas, this);
        //3. 아답터 세팅하기
        rv.setAdapter(ca);
        //4. 뷰 매니저 등록하기(뷰 모양 결정)
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}
