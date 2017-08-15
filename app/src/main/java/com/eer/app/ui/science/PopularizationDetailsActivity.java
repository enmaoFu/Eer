package com.eer.app.ui.science;

import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.eer.app.R;
import com.eer.app.base.BaseAty;

import butterknife.Bind;

/**
 * @title  文献科普详情
 * @date   2017/06/17
 * @author enmaoFu
 */
public class PopularizationDetailsActivity extends BaseAty{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.webview)
    WebView mWebView;

    private String title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_popularization_details;
    }

    @Override
    protected void initData() {

        title = getIntent().getStringExtra("title");
        initToolbar(mToolbar,title);

        //设置WebView属性，能够执行Javascript脚本
        mWebView.getSettings().setJavaScriptEnabled(true);
        //加载URL
        mWebView.loadUrl("http://www.jianshu.com/p/1d7ad186c2e7");
    }

    @Override
    public boolean setIsInitRequestData() {
        return false;
    }

    @Override
    protected void requestData() {

    }

}
