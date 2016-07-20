package org.chzz.treerecyclerview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.chzz.treerecyclerview.R;
import org.chzz.treerecyclerview.adapter.RecyclerAdapter;
import org.chzz.treerecyclerview.interfaces.OnScrollToListener;
import org.chzz.treerecyclerview.model.ItemData;

import java.util.List;

/**
 * @Author Zheng Haibo
 * @PersonalWebsite http://www.mobctrl.net
 * @Description
 */
public class MainActivity extends Activity {

	private RecyclerView recyclerView;

	private RecyclerAdapter myAdapter;

	private LinearLayoutManager linearLayoutManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		linearLayoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(linearLayoutManager);

		recyclerView.getItemAnimator().setAddDuration(100);
		recyclerView.getItemAnimator().setRemoveDuration(100);
		recyclerView.getItemAnimator().setMoveDuration(200);
		recyclerView.getItemAnimator().setChangeDuration(100);

		myAdapter = new RecyclerAdapter(this);
		recyclerView.setAdapter(myAdapter);
		myAdapter.setOnScrollToListener(new OnScrollToListener() {

			@Override
			public void scrollTo(int position) {
				recyclerView.scrollToPosition(position);
			}
		});
		initDatas();
	}

	private void initDatas() {
		List<ItemData> list = myAdapter.getChildrenByPath("/", 0);
		myAdapter.addAll(list, 0);
	}

}
