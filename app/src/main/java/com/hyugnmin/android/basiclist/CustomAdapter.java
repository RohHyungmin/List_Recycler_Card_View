package com.hyugnmin.android.basiclist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by besto on 2017-01-31.
 */

public class CustomAdapter extends BaseAdapter {
    LayoutInflater inflater;
    String datas[];
    Context context;


    //xml을 자바클래스 코드 객체로 바꿔주는것이 inflater/ 메모리에 올라가기 위해서는 자바코드여야 한다.
    public CustomAdapter(String datas[], Context context) {
        this.context = context;
        this.datas = datas;
    }
    /**
     * 사용하는 데이터의 총 개수
     * @return
     */
    @Override
    public int getCount() {
        return datas.length;
    }
    /**
     * 선택된 리스트 아이템
     * @param position
     * @return
     */

    @Override
    public Object getItem(int position) {
        return datas[position];
    }
    /**
     * 아이템의 인덱스 값
     * @param position
     * @return
     */

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override //리스트 아답터에서 뷰는 한 행 단위다. 한행 단위를 개발자가 직접만들어서 시스템에 넘겨줘야 한다.
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Log.i("List", "getView!!!!!!!!!!!");

        //한 행에 해당하는 레이아웃 xml을 뷰 객체로 만들어 준다.
        if(convertView == null) // 한 번 화면에 세팅됐던 행은 convertView에 담겨져서 돌아온다.
            convertView  = inflater.inflate(R.layout.list_item, null);
        //인플레이트된 뷰를 통해서 findViewById 함수를 사용한다.
        TextView textNo = (TextView) convertView.findViewById(R.id.textId);
        TextView textDay = (TextView) convertView.findViewById(R.id.textName);
        //inflate된 뷰의 위젯에 값을 세팅한다.
        textNo.setText((position+1)+"");
        textDay.setText(datas[position]);

        return convertView;
    }
}
