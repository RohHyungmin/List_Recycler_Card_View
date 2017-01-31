package com.hyugnmin.android.basiclist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class ListviewholderActivity extends AppCompatActivity {

    ArrayList<User> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewholder_activity);

        //1. 리스트뷰 가져오기
        ListView listView = (ListView) findViewById(R.id.listView);
        //2. 아답터 생성
        customHolderAdapter adapter = new customHolderAdapter(datas, this);
        listView.setAdapter(adapter);

        Data data = new Data();
        datas = data.get();
    }


    class customHolderAdapter extends BaseAdapter {

        ArrayList<User> datas;
        LayoutInflater inflater;

        public customHolderAdapter(ArrayList<User> datas, Context context) {
            this.datas = datas;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
    @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            //뷰 = 행이 화면에 보여져서 생성된 적이 있다면 재사용
            if(convertView == null){
                convertView = inflater.inflate(R.layout.list_holder_item, null);
                //생성한 위젯을 담아놓기 위한 임시공간
                holder = new Holder();

                holder.textId = (TextView) convertView.findViewById((R.id.textId));
                holder.textName = (TextView) convertView.findViewById((R.id.textName));
                holder.textAge = (TextView) convertView.findViewById((R.id.textAge));

                convertView.setTag(holder);
            }
            else {
                holder = (Holder)convertView.getTag();
            }

            //사용할 데이터 인스턴스를 ArrayList에서 꺼낸다
            User user = datas.get(position);

            holder.textId.setText(user.id + "");
            holder.textName.setText(user.name);
            holder.textAge.setText(user.age + "");

            return convertView;
        }

        //각 행에서 사용되는 위젯을 재사용하기 위한 Holder클래스
        class Holder {
            public TextView textId;
            public TextView textName;
            public TextView textAge;
        }
    }
}

