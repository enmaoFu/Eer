package com.eer.app.ui.mine;

import com.eer.app.R;
import com.eer.app.base.BaseFgt;

/**
 * @title  个人中心fragemnt
 * @date   2017/06/17
 * @author enmaoFu
 */
public class MineFragment extends BaseFgt {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initData() {

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

}
