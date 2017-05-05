package com.xrecycler.wzf.xrecyclerviewsample.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
 * 创建日期：2017/3/28
 * 版    本：1.0
 * 修订历史：
 * ================================================
 */
public class PageFragment extends Fragment {

    private XRecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    private ArrayList<String> listData;

    private int time = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, null);
        mRecyclerView = (XRecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setRefreshHeader(new MyHeaderView(getActivity()));
        mRecyclerView.setFootView(new MyFooterView(getActivity()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        time = 0;
                        listData.clear();
                        for (int i = 0; i < 15; i++) {
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
        for (int i = 0; i < 15; i++) {
            listData.add("item" + i);
        }
        mAdapter = new MyAdapter(listData);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}
