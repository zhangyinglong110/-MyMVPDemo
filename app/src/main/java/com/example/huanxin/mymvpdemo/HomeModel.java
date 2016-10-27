package com.example.huanxin.mymvpdemo;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/24 0024.
 */

public class HomeModel {


    private Thread mthread;


    public void asyncLoadDatas() {
        if (mthread != null) {
            mthread.interrupt();
            mthread = null;
        }
        mthread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (System.currentTimeMillis() % 2 == 0) {
                    EventBus.getDefault().post(new HomeEvent());
                } else {
                    List<String> datas = new ArrayList<>();
                    for (int i = 0; i < 20; i++) {
                        datas.add("我是第 " + i + " 条数据");
                    }
                    EventBus.getDefault().post(new HomeEvent(datas));
                }
            }
        });
        mthread.start();
    }


}
