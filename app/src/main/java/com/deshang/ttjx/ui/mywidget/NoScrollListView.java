package com.deshang.ttjx.ui.mywidget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 禁止滚动的ListView
 * Created by Administrator on 2015/10/21 0021.
 */
public class NoScrollListView extends ListView {

    public NoScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 设置不滚动
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
