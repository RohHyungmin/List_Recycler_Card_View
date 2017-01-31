package com.hyugnmin.android.basiclist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by besto on 2017-01-31.
 */

public class RecyclerCustomAdapter extends RecyclerView.Adapter<RecyclerCustomAdapter.CustomViewHolder> {
    ArrayList<User> datas;
    //리스트 각 행에서 사용되는 레이아웃 xml의 id
    int itemLayout;

    public RecyclerCustomAdapter(ArrayList<User> datas, int itemLayout){
        this.datas = datas;
        this.itemLayout = itemLayout;
    }

    //뷰를 생성해서 홀더에 저장하는 역할
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
                //context.getSystemService...와 같은 문장

        CustomViewHolder cvh = new CustomViewHolder(view);

        return cvh;
    }

    //listView 에서의 getView 함수를 대체
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        User user = datas.get(position);
        holder.textId.setText(user.id +"");
        holder.textName.setText(user.name);
        holder.textAge.setText(user.age +"");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //Recycler 뷰에서 사용하는 뷰홀더 / 이 뷰 홀더를 사용하는 Adapter는 generic으로 선언된 부모객체를 상속받아 구현해야 한다.
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView textId, textName, textAge;

        public CustomViewHolder(View itemView) {
            super(itemView);
            //생성자가 호출되는 순간, new 하는 순간 내부의 위젯을 생성해서 변수에 담아둔다.
            textId = (TextView) itemView.findViewById(R.id.textId);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textAge = (TextView) itemView.findViewById(R.id.textAge);

        }
    }
}
