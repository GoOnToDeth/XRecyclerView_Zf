package com.xrecycler.wzf.xrecyclerviewsample;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.xrecycler.wzf.xrecyclerview_zf.ptr.FooterView;


/**
 * ================================================
 * 描    述：
 * 作    者：王智凡
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

    @Override
    public View onCreateFooterView() {
        setBackgroundColor(Color.BLUE);
        textView = new TextView(getContext());
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(16);
        textView.setText("上拉加载更多...");
        FrameLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        textView.setPadding(0, 30, 0, 30);
        textView.setLayoutParams(params);
        return textView;
    }

    private TextView textView;

    @Override
    public void setStatus(int state) {
        switch (state) {
            case FooterView.STATE_LOADING:
                textView.setText("正在加载....");
                break;
            case FooterView.STATE_COMPLETE:
                textView.setText("加载完成");
                break;
            case FooterView.STATE_NOMORE:
                textView.setText("我也是有底线的~");
                break;
        }
    }
}
