package org.chzz.treerecyclerview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import org.chzz.treerecyclerview.R;
import org.chzz.treerecyclerview.adapter.Adapter;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/7/21
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/7/21--9:22
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class MainNewActivity extends Activity {
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mAdapter = new Adapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.getItemAnimator().setAddDuration(200);
        mRecyclerView.getItemAnimator().setRemoveDuration(200);
        mRecyclerView.getItemAnimator().setMoveDuration(200);
        mRecyclerView.getItemAnimator().setChangeDuration(200);


    }
}
