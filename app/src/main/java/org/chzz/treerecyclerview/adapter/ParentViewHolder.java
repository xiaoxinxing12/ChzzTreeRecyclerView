package org.chzz.treerecyclerview.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.chzz.treerecyclerview.R;


/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/7/21
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/7/21--10:47
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class ParentViewHolder extends BaseViewHolder {
    TextView mTextView;
    LinearLayout mLinearLayout;
    public ParentViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.tv_t);
        mLinearLayout = (LinearLayout) itemView.findViewById(R.id.ll_item);
    }
}
