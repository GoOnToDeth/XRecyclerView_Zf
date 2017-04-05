package com.xrecycler.wzf.xrecyclerviewsample;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.xrecycler.wzf.xrecyclerview_zf.ptr.HeaderView;


/**
 * ================================================
 * 描    述：
 * 作    者：wzf
 * 创建日期：2017/3/30
 * 版    本：1.0
 * 修订历史：
 * ================================================
 */
public class MyHeaderView extends HeaderView {

    public MyHeaderView(Context context) {
        super(context);
    }

    public MyHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyHeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private TextView textView;

    @Override
    public View onCreateHeaderView() {
        textView = new TextView(getContext());
        textView.setText("下拉刷新");
        FrameLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(params);
        textView.setBackgroundColor(Color.RED);
        textView.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        textView.setPadding(0, 0, 0, 100);
        return textView;
    }

    @Override
    public void setState(int state) {
        if (state == mState) return;
        switch (state) {
            case STATE_NORMAL:
                if (mState == STATE_RELEASE_TO_REFRESH) {
                    textView.setText("下拉刷新");
                } else {
                    textView.setText("下拉刷新");
                }
                break;
            case STATE_RELEASE_TO_REFRESH:
                textView.setText("松开刷新");
                break;
            case STATE_START_REFRESH:
                // 一定要调用父类的这个方法，不然在松手后无法复原
                smoothScrollTo(mMeasuredHeight);
                textView.setText("开始刷新");
                break;
            case STATE_REFRESH_DONE:
                textView.setText("刷新完成");
                break;
            default:
        }
        mState = state;
    }
}
