package com.eer.app.ui.home;
import android.view.View;
import android.widget.Button;

import com.eer.app.R;
import com.eer.app.base.BaseFgt;
import com.eer.app.view.BannerImageLoader;
import com.em.banner.Banner;
import com.em.banner.BannerConfig;
import com.em.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @title  益耳首页fragemnt
 * @date   2017/06/17
 * @author enmaoFu
 */
public class HomeFragment extends BaseFgt {

    @Bind(R.id.banner)
    Banner mBanner;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

        //设置图片加载集合
        List<String> imageArray = new ArrayList<>();
        imageArray.add("http://img5q.duitang.com/uploads/item/201504/29/20150429185037_BwuRP.jpeg");
        imageArray.add("http://i0.hdslb.com/group1/M00/93/82/oYYBAFbfnJKAYF02AACobXvB2EA676.jpg");
        imageArray.add("http://i1.hdslb.com/video/98/9808be3eb2f11c4a7aed287a5aab1b3a.jpg");

        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new BannerImageLoader());
        //设置图片集合
        mBanner.setImages(imageArray);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        //mBanner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(2000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();

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

    @OnClick({R.id.but})
    @Override
    public void btnClick(View view) {
       switch (view.getId()){
           case R.id.but:
               startActivity(TestActivity.class,null);
               break;
       }
    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        mBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        mBanner.stopAutoPlay();
    }
}
