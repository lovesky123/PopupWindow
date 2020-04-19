package com.example.popupwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MyPopupwWndow extends PopupWindow {
    Context mContext;
    private LayoutInflater mInflater;
    private View mContentView;
    TextView tv_sure, tv_cancel;

    public MyPopupwWndow(Context context) {
        super(context);
        this.mContext = context;
//        打气筒
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        打气
        mContentView = mInflater.inflate(R.layout.layout_dialog, null);
//        设置View
        setContentView(mContentView);

//       设置宽高
        setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        /**
         * 设置进出动画
         */
        setAnimationStyle(R.style.MyPopupWindow);
        /**
         * 设置背景，只有设置了这个才可以点击外边和BACK消失
         */
        setBackgroundDrawable(new ColorDrawable());
        /**
         * 设置可以获取焦点
         */
        setFocusable(true);
        /**
         * 设置点击外边可消失
         */
        setOutsideTouchable(true);
        /**
         * 设置可以接触
         */
        setTouchable(true);
        /**
         * 设置点击外部可消失
         */
        setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // 判断是不是点击了外部
                if (motionEvent.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    return true;
                }
                return false;
            }
        });
        /**
         * 初始化View 与 监听
         */
        initView();
        initListener();
    }

    private void initListener() {
        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "确定", Toast.LENGTH_SHORT).show();
            }
        });
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "消失", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }

    private void initView() {
        tv_sure = mContentView.findViewById(R.id.tv_sure);
        tv_cancel = mContentView.findViewById(R.id.tv_cancel);
    }

}
