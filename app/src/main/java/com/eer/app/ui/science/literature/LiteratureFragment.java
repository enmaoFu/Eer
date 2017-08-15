package com.eer.app.ui.science.literature;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.eer.app.R;
import com.eer.app.adapter.SciencePublicAdapter;
import com.eer.app.base.BaseFgt;
import com.eer.app.entity.SciencePublicEntity;
import com.eer.app.ui.science.PopularizationDetailsActivity;
import com.em.baseframe.adapter.recyclerview.BaseQuickAdapter;
import com.em.baseframe.adapter.recyclerview.listener.OnItemClickListener;
import com.em.baseframe.view.refresh.PtrInitHelper;
import com.em.refresh.PtrDefaultHandler;
import com.em.refresh.PtrFrameLayout;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * @title  文献fragemnt
 * @date   2017/06/17
 * @author enmaoFu
 */
public class LiteratureFragment extends BaseFgt{

    @Bind(R.id.refresh)
    PtrFrameLayout mRefresh;
    @Bind(R.id.recyvlerview)
    RecyclerView mRecyclerView;

    private SciencePublicAdapter mSciencePublicAdapter;
    private List<SciencePublicEntity> mSciencePublicEntities;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_literature;
    }

    @Override
    protected void initData() {

        /**
         * 设置下拉刷新
         */
        PtrInitHelper.initPtr(getActivity(), mRefresh);
        mRefresh.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefresh.refreshComplete();
                    }
                }, 1500);
            }
        });

        /**
         * 设置recyclerview
         */
        //实例化布局管理器
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        //实例化适配器
        mSciencePublicAdapter = new SciencePublicAdapter(R.layout.item_science_public, setData());
        //设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        //设置间隔样式
        mRecyclerView.addItemDecoration(
        new HorizontalDividerItemDecoration.Builder(getActivity())
                        .color(Color.parseColor("#CCCCCC"))
                        .sizeResId(R.dimen.recyclerview_item_hr)
                        .build());
        //大小不受适配器影响
        mRecyclerView.setHasFixedSize(true);
        //设置加载动画类型
        mSciencePublicAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        //设置删除动画类型
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置监听
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("title","文献详情");
                startActivity(PopularizationDetailsActivity.class,bundle);
            }
        });
        //设置adapter
        mRecyclerView.setAdapter(mSciencePublicAdapter);
    }

    @Override
    public void onUserVisible() {
        super.onUserVisible();
    }

    @Override
    protected boolean setIsInitRequestData() {
        return true;
    }

    @Override
    protected void requestData() {

    }

    public List<SciencePublicEntity> setData(){
        mSciencePublicEntities = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            mSciencePublicEntities.add(new SciencePublicEntity());
        }
        return mSciencePublicEntities;
    }

}
