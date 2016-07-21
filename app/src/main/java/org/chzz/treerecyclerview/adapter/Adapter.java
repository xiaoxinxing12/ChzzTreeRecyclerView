package org.chzz.treerecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.chzz.treerecyclerview.R;
import org.chzz.treerecyclerview.model.ItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/7/21
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/7/21--9:25
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class Adapter extends RecyclerView.Adapter<BaseViewHolder> {
    Context mContext;
    List<ItemEntity> mEntities = new ArrayList<>();

    private boolean isExpand;

    public Adapter(Context context) {
        mContext = context;
        for (int i = 0; i < 10; i++) {
            mEntities.add(new ItemEntity(0, i + ""));
        }

    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_adapter_parent, parent, false);
                return new ParentViewHolder(view);
            case 1:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_adapter_child, parent, false);
                return new ChildViewHolder(view);
            default:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_adapter_parent, parent, false);
                return new ParentViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ItemEntity bean = mEntities.get(position);
        switch (bean.getFlag()) {
            case 0:
                ParentViewHolder parentViewHolder = (ParentViewHolder) holder;
                initParent(parentViewHolder, position, bean);
                break;
            case 1:
                ChildViewHolder childViewHolder = (ChildViewHolder) holder;
                initChild(childViewHolder, position, bean);
                break;

        }


    }

    @Override
    public int getItemCount() {
        return mEntities.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mEntities.get(position).getFlag();
    }

    private void initParent(ParentViewHolder parentViewHolder, final int position, final ItemEntity bean) {
        parentViewHolder.mTextView.setText(bean.getName());
        parentViewHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bean.isExpand()) {
                    for (int i = 0; i < 3; i++) {
                        mEntities.add(position + 1, new ItemEntity(1, position + ">>" + i));
                    }
                    bean.setExpand(true);
                    notifyItemRangeInserted(position + 1, 3);
                } else {
                    for (int i = 0; i < 3; i++) {
                        mEntities.remove(position + 1);
                    }
                    bean.setExpand(false);
                    notifyItemRangeRemoved(position + 1, 3);

                }
                ThreadUtil.runInUIThread(new Runnable() {
                    @Override
                    public void run() {
                        notifyDataSetChanged();
                    }
                }, 250);

            }
        });
    }

    private void initChild(ChildViewHolder childViewHolder, final int position, final ItemEntity bean) {
        childViewHolder.mTextView.setText(bean.getName());
        childViewHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, bean.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
