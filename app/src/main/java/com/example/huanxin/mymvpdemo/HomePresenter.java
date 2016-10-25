package com.example.huanxin.mymvpdemo;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24 0024.
 */

public class HomePresenter implements HomeModel.Model {

    private HomeView mHomeView;

    public void loadData() {
        mHomeView.showLoading();
        new HomeModel(this).asyncLoadDatas();
    }


    @Override
    public void setData(List<String> datas) {
        mHomeView.hideLoading();
        if (datas == null) {
            mHomeView.showErrorMsg("未知错误！");
            return;
        }
        mHomeView.refreshListView(datas);
    }

    /**
     * Presenter和视图关联
     * <p/>
     * 在Activity的onCreate()中调用
     * <p/>
     * 在Fragment的onViewCreated()或onActivityCreated()中调用
     */
    public final void atteachView(HomeView homeView) {
        mHomeView = homeView;
    }

    /**
     * Presenter和视图解除关联
     * <p/>
     * 在Activity的onDestroy()中调用
     * <p/>
     * 在Fragment的onViewDestroyed()中调用
     */

    public final void detachView() {
        mHomeView = null;
        // 设置一个空对象，并不是直接把对象设置为null,只是空对象不对做任何操作。
        mHomeView = getNullObject();
    }


    private final HomeView getNullObject() {
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
