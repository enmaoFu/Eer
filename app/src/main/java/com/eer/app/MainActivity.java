package com.eer.app;

import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.eer.app.ui.home.HomeFragment;
import com.eer.app.ui.science.PopularizationFragment;
import com.em.baseframe.base.BaseActivity;
import com.em.baseframe.base.BaseLazyFragment;
import com.em.baseframe.view.navigation.BottomMenuView;
import com.eer.app.ui.mine.MineFragment;
import com.eer.app.ui.hearing.HearingFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.menu)
    BottomMenuView mMenu;

    public static List<RadioButton> radioButtons;

    //记录是否有首次按键
    private boolean mBackKeyPressed = false;

    /**
     * 解决切换到HomeActivity界面的发送界面黑屏问题
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

        radioButtons = mMenu.getRadioButtons();

        //底部导航栏切换图标
        List<Drawable> drawables = new ArrayList<>();
        drawables.add(getResources().getDrawable(R.drawable.selector_tab_home));
        drawables.add(getResources().getDrawable(R.drawable.selector_tab_hearing));
        drawables.add(getResources().getDrawable(R.drawable.selector_tab_popularization));
        drawables.add(getResources().getDrawable(R.drawable.selector_tab_mine));

        //底部导航栏标题
        List<String> menus = new ArrayList<>();
        menus.add("益耳首页");
        menus.add("助听设备");
        menus.add("文献科普");
        menus.add("个人中心");

        //底部导航栏页面
        List<BaseLazyFragment> fgts = new ArrayList<>();
        fgts.add(new HomeFragment());
        fgts.add(new HearingFragment());
        fgts.add(new PopularizationFragment());
        fgts.add(new MineFragment());

        mMenu.init(drawables, R.color.selector_main_rb_text, fgts, menus, getSupportFragmentManager());

        /**
         * 在使用ViewPager加Fragment的时候，滑动每个Fragment的时候，都会重新调用onCreate()方法，因为Fragment页面没有被缓存。
         * 使用上面的setOffscreenPageLimit()方法后，可以缓存Fragment页面，避免滑动显示的时候多次调用onCreate方法来进行刷新。
         */
        mMenu.getViewPager().setOffscreenPageLimit(4);
        mMenu.setListener(new BottomMenuView.CheckChangeListener() {
            @Override
            public void onCheckChanged(ViewPager pager, RadioGroup group, int checkedPosition) {
                switch (checkedPosition) {
                    case 0:
                        pager.setCurrentItem(0);
                        break;
                    case 1:
                        pager.setCurrentItem(1);
                        break;
                    case 2:
                        pager.setCurrentItem(2);
                        break;
                    case 3:
                        pager.setCurrentItem(3);
                        break;
                }
            }
        });

    }

    @Override
    protected boolean setIsInitRequestData() {
        return false;
    }

    @Override
    protected void requestData() {

    }

    @Override
    public void btnClick(View view) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

    @Override
    public void onBackPressed() {
        if(!mBackKeyPressed){
            showToast("再按一次退出应用");
            mBackKeyPressed = true;
            //延时两秒，如果超出则擦除第一次按键记录
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    mBackKeyPressed = false;
                }
            }, 2000);
        }else{
            //退出程序
            this.finish();
            System.exit(0);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMenu.getFgts().get(0).onUserInvisible();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        radioButtons.clear();
    }
}
