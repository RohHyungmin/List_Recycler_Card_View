package com.hyugnmin.android.basiclist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class RecyclerviewActivity extends AppCompatActivity {

    ArrayList<User> datas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        Data data = new Data();
        datas = data.get();

        //1.Recycler View == 리스트뷰 + 뷰홀더
        //리사이클러뷰 가져오기
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //2.아답터 생성하기
        RecyclerCustomAdapter rca = new RecyclerCustomAdapter(datas, R.layout.list_holder_item);

        //3.리사이클러 뷰에 아답터 세팅하기

        recyclerView.setAdapter(rca);

        //4.리사이클러 뷰 매니저 등록하기(뷰 모양 결정)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
