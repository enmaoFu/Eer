package com.eer.app.ui.science;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.eer.app.R;
import com.eer.app.base.BaseFgt;
import com.eer.app.ui.science.literature.LiteratureFragment;
import com.eer.app.ui.science.popularization.ScienceFragment;
import com.em.baseframe.util.DensityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * @title  文献科普fragemnt
 * @date   2017/06/17
 * @author enmaoFu
 */
public class PopularizationFragment extends BaseFgt{

    @Bind(R.id.tab_layout)
    TabLayout mTab;
    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    private List<BaseFgt> mFragments;
    private List<String> mTabsString;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_popularization;
    }

    @Override
    protected void initData() {

        mFragments = new ArrayList<>();
        mTabsString = new ArrayList<>();
        mTabsString.add("听学文献");
        mTabsString.add("听学科普");

        mFragments.add(new LiteratureFragment());
        mFragments.add(new ScienceFragment());

        //设置间隔
        LinearLayout linearLayout = (LinearLayout) mTab.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.tab_divider_vertical));
        linearLayout.setDividerPadding(DensityUtils.dp2px(getActivity(),15));

        //普通在activity里面嵌套fragment里这样写
        //pageAdapter pageAdapter = new pageAdapter(getActivity().getSupportFragmentManager());
        //在fragment里嵌套fragment的时候这样写
        pageAdapter pageAdapter = new pageAdapter(getChildFragmentManager());
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(pageAdapter);

        mTab.setupWithViewPager(mViewPager);

        if (DensityUtils.getScreenWidth(getActivity())<=700){
            mTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        }else {
            mTab.setTabMode(TabLayout.MODE_FIXED);
        }

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

    class pageAdapter extends FragmentStatePagerAdapter {
        public pageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabsString.get(position);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // super.onSaveInstanceState(outState);
    }

}
