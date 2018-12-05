package com.deshang.ttjx.ui.mywidget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.deshang.ttjx.R;
import com.deshang.ttjx.framework.utils.UserPathUtils;

/**
 * 每日弹出Dialog
 * Created by L on 2018年6月19日15:26:03
 */

public class WithdrawalFirstDialog extends Dialog implements View.OnClickListener {

    private Context context;

    public WithdrawalFirstDialog(@NonNull Context context) {
        super(context, R.style.Dialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = View.inflate(context, R.layout.dialog_withdrawal_first_time, null);
        setContentView(view);

        initView(view);
    }

    /***
     * 初始化组件
     * @param view
     */
    private void initView(View view) {
        ImageView close = (ImageView) view.findViewById(R.id.close);
        close.setOnClickListener(this);
        ImageView go_read = (ImageView) view.findViewById(R.id.go_read);
        go_read.setOnClickListener(this);
        setCancelable(false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close:
                dismiss();
                break;

            case R.id.go_read:
                dismiss();
                if (listener != null) {
                    listener.onClick();
                }
                break;

        }
    }

    @Override
    public void show() {
        super.show();
        UserPathUtils.commitUserPath(33);
    }

    private OnClickListener listener;

    public interface OnClickListener {
        void onClick();
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

}
