package com.xrecycler.wzf.xrecyclerviewsample.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.xrecycler.wzf.xrecyclerview_zf.ptr.XRecyclerView;
import com.xrecycler.wzf.xrecyclerviewsample.MyAdapter;
import com.xrecycler.wzf.xrecyclerviewsample.R;
import com.xrecycler.wzf.xrecyclerviewsample.MyFooterView;
import com.xrecycler.wzf.xrecyclerviewsample.MyHeaderView;

import java.util.ArrayList;

/**
 * ================================================
 * 描    述：
 * 作    者：wzf
 * 创建日期：2017/4/5
 * 版    本：1.0
 * 修订历史：
 * ================================================
 */
public class GridActivity extends AppCompatActivity {

    private int time = 0;
    private ArrayList<String> listData;
    private MyAdapter mAdapter;

    private XRecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page);
        mRecyclerView = (XRecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setRefreshHeader(new MyHeaderView(this));
        mRecyclerView.setFootView(new MyFooterView(this));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        time = 0;
                        listData.clear();
                        for (int i = 0; i < 20; i++) {
                            listData.add("item" + i + "after " + time + " times of refresh");
                        }
                        mAdapter.notifyDataSetChanged();
                        mRecyclerView.refreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (time >= 2) {
                            for (int i = 0; i < 3; i++) {
                                listData.add("item最后" + i + "个");
                            }
                            mAdapter.notifyDataSetChanged();
                            mRecyclerView.setNoMore(true);
                        } else {
                            for (int i = 0; i < 15; i++) {
                                listData.add("item" + (1 + listData.size()));
                            }
                            mRecyclerView.loadMoreComplete();
                            mAdapter.notifyDataSetChanged();
                        }
                        time++;
                    }
                }, 2000);
            }
        });

        listData = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            listData.add("item" + i);
        }
        mAdapter = new MyAdapter(listData);
        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.refresh();
    }
}
