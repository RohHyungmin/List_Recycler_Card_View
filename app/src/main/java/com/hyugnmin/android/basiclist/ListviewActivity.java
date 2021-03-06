package com.hyugnmin.android.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListviewActivity extends AppCompatActivity {

    ListView listView;

    String array[] = {"월", "화", "수", "목", "금", "토", "일"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        //1.리스트 뷰를 가져온다
        listView = (ListView) findViewById(R.id.ListView2);
        //2.아답터를 정의한다.
        CustomAdapter adapter = new CustomAdapter(array, this);
        //3. 리스트뷰에 아답터를 세팅한다
        listView.setAdapter(adapter);
        //4. 리스트뷰에 리스너를 달아준다
        listView.setOnItemClickListener(listener);
    }
        //리스너 생성
    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //1. detail 액티비티로 전환하기 위해 intent 생성
            Intent intent = new Intent(ListviewActivity.this, DetailActivity.class);
            //2. 넘길 데이터 세팅
            intent.putExtra("no", position+1);
            intent.putExtra("day", array[position]);
            //3. 액티비티 호출
            startActivity(intent);
        }
    };
}
