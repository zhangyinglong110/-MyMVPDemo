package com.example.huanxin.mymvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements HomeView {

    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.btn_refresh)
    Button btnRefresh;
    @BindView(R.id.prg_loading)
    ProgressBar prgLoading;


    private ArrayAdapter<String> arrayAdapter;
    private Unbinder unbinder;
    private HomePresenter mHomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHomePresenter = new HomePresenter();
        mHomePresenter.atteachView(this);
        mHomePresenter.onCreat();
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        unbinder = ButterKnife.bind(this);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);

    }

    @OnClick(R.id.btn_refresh)
    public void loadData() {
        mHomePresenter.loadData();
    }

    /*************
     * start 视图的变化
     *********/
    @Override
    public void showLoading() {
        btnRefresh.setVisibility(View.GONE);
        prgLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        prgLoading.setVisibility(View.GONE);
        btnRefresh.setVisibility(View.VISIBLE);
    }

    @Override
    public void refreshListView(List<String> datas) {
        arrayAdapter.clear();
        arrayAdapter.addAll(datas);
        arrayAdapter.notifyDataSetChanged();

    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /*************
     * end 视图的变化
     *********/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mHomePresenter.detachView();
        mHomePresenter.onDestory();
    }
}
