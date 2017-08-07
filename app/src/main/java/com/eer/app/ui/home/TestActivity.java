package com.eer.app.ui.home;

import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.eer.app.R;
import com.eer.app.base.BaseAty;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/7/26.
 */

public class TestActivity extends BaseAty{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initData() {
        initToolbar(mToolbar,"测试的");
    }

    @Override
    protected void requestData() {

    }

    @Override
    protected void initStatusBar() {
        super.initStatusBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_public, menu);
        menu.getItem(0).setIcon(R.drawable.anv_omit);
        return super.onCreateOptionsMenu(menu);
    }
}
