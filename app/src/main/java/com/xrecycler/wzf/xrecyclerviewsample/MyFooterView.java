package com.xrecycler.wzf.xrecyclerviewsample;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xrecycler.wzf.xrecyclerview_zf.ptr.FooterView;


/**
 * ================================================
 * 描    述：
 * 作    者：wzf
 * 创建日期：2017/3/29
 * 版    本：1.0
 * 修订历史：
 * ================================================
 */
public class MyFooterView extends FooterView {

    public MyFooterView(Context context) {
        super(context);
    }

    public MyFooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyFooterView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private LinearLayout layoutLoading;
    private LinearLayout layoutNoMore;

    @Override
    public View onCreateFooterView() {
        Context context = getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.ptr_footer_default, null);
        layoutLoading = (LinearLayout) view.findViewById(R.id.layout_footer_loading);
        layoutNoMore = (LinearLayout) view.findViewById(R.id.layout_footer_nomore);
        return view;
    }

    @Override
    public void setStatus(int state) {
        switch (state) {
            case FooterView.STATE_LOADING:
                setLayoutLoadingVisiable(true);
                break;
            case FooterView.STATE_COMPLETE:
                //  加载完成
                break;
            case FooterView.STATE_NOMORE:
                setLayoutLoadingVisiable(false);
                break;
        }
    }

    private void setLayoutLoadingVisiable(boolean isShow) {
        layoutLoading.setVisibility(isShow ? VISIBLE : GONE);
        layoutNoMore.setVisibility(isShow ? GONE : VISIBLE);
    }
}
