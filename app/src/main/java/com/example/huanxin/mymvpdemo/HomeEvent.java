package com.example.huanxin.mymvpdemo;

import java.util.List;

/**
 * Created by Administrator on 2016/10/27 0027.
 */

public class HomeEvent {
    public final List<String> datas;

    public HomeEvent() {
        datas = null;
    }

    public HomeEvent(List<String> datas) {
        this.datas = datas;
    }
}
