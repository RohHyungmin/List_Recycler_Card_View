package com.hyugnmin.android.basiclist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by besto on 2017-01-31.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CustomViewHolder> {
    ArrayList<User> datas;
    //리스트 각 행에서 사용되는 레이아웃 xml의 id

    Context context; //클릭처리, 애니매이션 등을 위해 시스템 자원 사용이 필요

    public CardAdapter(ArrayList<User> datas, Context context){
        this.datas = datas;
        this.context = context;

    }


    //뷰를 생성해서 홀더에 저장하는 역할
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_item, parent, false);
                //context.getSystemService...와 같은 문장

        CustomViewHolder cvh = new CustomViewHolder(view);

        return cvh;
    }
    //listView 에서의 getView 함수를 대체
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final User user = datas.get(position);
        holder.textId.setText(user.id +"");
        holder.textName.setText(user.name);
        holder.textAge.setText(user.age +"");

        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("no", user.id);
                intent.putExtra("day", user.name);
                context.startActivity(intent);
            }
        });

        //카드 뷰 애니메이션
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right);
        holder.cardView.setAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //Recycler 뷰에서 사용하는 뷰홀더 / 이 뷰 홀더를 사용하는 Adapter는 generic으로 선언된 부모객체를 상속받아 구현해야 한다.
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView textId, textName, textAge;
        CardView cardView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            //생성자가 호출되는 순간, new 하는 순간 내부의 위젯을 생성해서 변수에 담아둔다.
            textId = (TextView) itemView.findViewById(R.id.textId);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textAge = (TextView) itemView.findViewById(R.id.textAge);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

        }
    }
}
