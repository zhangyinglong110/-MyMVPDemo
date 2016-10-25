package com.example.huanxin.mymvpdemo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/24 0024.
 */

public class HomeModel {


    public interface Model {
        void setData(List<String> datas);
    }

    private Thread mthread;
    private Model mModel;
    private Handler mHandler;

    public HomeModel(Model model) {
        mModel = model;
        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    List<String> datas = (List<String>) msg.obj;
                    mModel.setData(datas);
                }
            }
        };
    }


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
                List<String> datas = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    datas.add("我是第 " + i + " 条数据");
                }
                Message msg = new Message();
                msg.obj = datas;
                msg.what = 1;
                mHandler.sendMessage(msg);
            }
        });
        mthread.start();
    }


}
