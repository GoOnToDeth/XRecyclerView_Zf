package com.xrecycler.wzf.xrecyclerviewsample;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

    private ProgressBar pbLoading;
    private TextView textView;
    private ImageView ivArrow;

    private static final int ROTATE_ANIM_DURATION = 180;

    private Animation mRotateUpAnim;
    private Animation mRotateDownAnim;

    @Override
    public View onCreateHeaderView() {
        Context context = getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.ptr_header_default, null);
        pbLoading = (ProgressBar) view.findViewById(R.id.pb_loading);
        textView = (TextView) view.findViewById(R.id.tv_ptr_txt);
        ivArrow = (ImageView) view.findViewById(R.id.iv_arrow);

        mRotateUpAnim = new RotateAnimation(0.0f, -180.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateUpAnim.setFillAfter(true);
        mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateDownAnim.setFillAfter(true);
        return view;
    }

    @Override
    public void setState(int state) {
        if (state == mState) return;
        ivArrow.clearAnimation();
        switch (state) {
            case STATE_NORMAL:
                setVisiable(true, false);
                if (mState == STATE_RELEASE_TO_REFRESH) {
                    ivArrow.startAnimation(mRotateDownAnim);
                } else {
                    ivArrow.clearAnimation();
                }
                textView.setText("下拉刷新...");
                break;
            case STATE_RELEASE_TO_REFRESH:
                setVisiable(true, false);
                ivArrow.clearAnimation();
                ivArrow.startAnimation(mRotateUpAnim);
                textView.setText("松开刷新...");
                break;
            case STATE_START_REFRESH:
                setVisiable(false, true);
                textView.setText("正在刷新...");
                break;
            case STATE_REFRESH_DONE:
                setVisiable(false, false);
                textView.setText("刷新完成");
                break;
        }
    }

    private void setVisiable(boolean isShowArrow, boolean isShowProgress) {
        ivArrow.setVisibility(isShowArrow ? VISIBLE : GONE);
        pbLoading.setVisibility(isShowProgress ? VISIBLE : GONE);
    }
}
