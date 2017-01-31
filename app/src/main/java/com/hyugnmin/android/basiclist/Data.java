package com.hyugnmin.android.basiclist;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by besto on 2017-01-31.
 */
public class Data {
    private ArrayList<User> datas;

    public ArrayList<User> get() {
        return datas;
    }

    public Data() {
        datas = new ArrayList<>();
        load();
    }

    //datas에 100명의 유저를 생성해서 담는다
    private void load() {
        //특정범위의 무작위 난수 생성
        Random random = new Random();

        for(int i = 0; i<10000; i++) {
            User user = new User();
            user.id = i+1;
            user.name = "David" + user.id;
            user.age = random.nextInt(80);
            Log.i("Random", "Number=" + user.age);

            datas.add(user);
        }
    }

}
