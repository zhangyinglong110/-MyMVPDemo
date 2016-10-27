package com.example.huanxin.mymvpdemo;

import com.example.huanxin.mymvpdemo.basemvp.MvpPresenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24 0024.
 */

public class HomePresenter extends MvpPresenter<HomeView> {


    public void loadData() {
        getView().showLoading();
        new HomeModel().asyncLoadDatas();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(HomeEvent homeEvent) {
        getView().hideLoading();
        if (homeEvent.datas == null) {
            getView().showErrorMsg("未知错误！");
            return;
        }
        getView().refreshListView(homeEvent.datas);
    }

    public HomeView getNullObject() {
        HomeView homeView = new HomeView() {
            @Override
            public void showLoading() {
            }

            @Override
            public void hideLoading() {
            }

            @Override
            public void refreshListView(List<String> datas) {
            }

            @Override
            public void showErrorMsg(String msg) {
            }
        };
        return homeView;
    }


}
