package com.example.huanxin.mymvpdemo;

import com.example.huanxin.mymvpdemo.basemvp.MvpPresenter;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24 0024.
 */

public class HomePresenter extends MvpPresenter<HomeView> implements HomeModel.Model {


    public void loadData() {
        getView().showLoading();
        new HomeModel(this).asyncLoadDatas();
    }


    @Override
    public void setData(List<String> datas) {
        getView().hideLoading();
        if (datas == null) {
            getView().showErrorMsg("未知错误！");
            return;
        }
        getView().refreshListView(datas);
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
