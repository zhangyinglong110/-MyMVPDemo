package com.example.huanxin.mymvpdemo;

import com.example.huanxin.mymvpdemo.basemvp.MvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24 0024.
 */

public interface HomeView extends MvpView{
    /**
     * 当开始加载数据后，显示的视图工作
     */
    void showLoading();

    /**
     * 当加载完数据后，显示的视图工作
     */
    void hideLoading();

    /**
     * 当结束加载数据后，将用来掉用刷新数据的方法
     *
     * @param datas 加载的数据
     */
    void refreshListView(List<String> datas);

    /**
     * 在处理业务的过程中出现错误时，显示错误信息。
     *
     * @param msg 错误信息
     */
    void showErrorMsg(String msg);


}
