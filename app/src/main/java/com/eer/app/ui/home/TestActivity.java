package com.eer.app.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eer.app.R;
import com.eer.app.base.BaseAty;
import com.em.baseframe.view.popupwindow.CBDialogBuilder;

import butterknife.Bind;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/26.
 */

public class TestActivity extends BaseAty{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    private int curSelectedItemPos = 2;

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

    @OnClick({R.id.pop_1,R.id.pop_2,R.id.pop_3,R.id.pop_4,R.id.pop_5,R.id.pop_6,R.id.pop_7,R.id.pop_8,R.id.pop_9,R.id.pop_10})
    @Override
    public void btnClick(View view) {
        switch (view.getId()){
            case R.id.pop_1:
                new CBDialogBuilder(this)
                        .setTouchOutSideCancelable(true)
                        .showCancelButton(true)
                        .setTitle("这是一个普通样式的对话框")
                        .setMessage("this is a normal CBDialog")
                        .setConfirmButtonText("确定")
                        .setCancelButtonText("取消")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .create().show();
                break;
            case R.id.pop_2:
                new CBDialogBuilder(this)
                        .setTouchOutSideCancelable(true)
                        .showCancelButton(true)
                        .setTitle("设置按钮和信息文字样式")
                        .setMessage("this is a normal CBDialog")
                        .setMessageTextSize(16)
                        .setMessageTextColor(Color.BLUE)
                        .setConfirmButtonText("确定")
                        .setConfirmBackgroundResouce(R.drawable.custom_button_background_right)
                        .setConfirmButtonTextColor(Color.WHITE)
                        .setCancelButtonText("取消")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .create().show();
                break;
            case R.id.pop_3:
                new CBDialogBuilder(this)
                        .setTouchOutSideCancelable(true)
                        .showCancelButton(false)
                        .setTitle("单个按钮")
                        .setMessage("this is a normal CBDialog")
                        .setConfirmButtonText("确定")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .create().show();
                break;
            case R.id.pop_4:
                new CBDialogBuilder(this)
                        .setTouchOutSideCancelable(true)
                        .showCancelButton(true)
                        .setTitle("这是一个有按钮监听的对话框")
                        .setMessage("this is a normal CBDialog with listener")
                        .setConfirmButtonText("ok")
                        .setCancelButtonText("cancel")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .setDialoglocation(CBDialogBuilder.DIALOG_LOCATION_BOTTOM)
                        .setButtonClickListener(false, new CBDialogBuilder.onDialogbtnClickListener() {
                            @Override
                            public void onDialogbtnClick(Context context, Dialog dialog, int whichBtn) {
                                switch (whichBtn) {
                                    case BUTTON_CONFIRM:
                                        showToast("点击了确认按钮");
                                        dialog.dismiss();
                                        break;
                                    case BUTTON_CANCEL:
                                        showToast("点击了取消按钮");
                                        break;
                                }
                            }
                        })
                        .create().show();
                break;
            case R.id.pop_5:
                new CBDialogBuilder(this)
                        .setTouchOutSideCancelable(false)
                        .showConfirmButton(false)
                        .setTitle("选择文字大小")
                        .setConfirmButtonText("ok")
                        .setCancelButtonText("cancel")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .setItems(new String[]{"较小", "中等", "较大", "巨无霸"}, new CBDialogBuilder.onDialogItemClickListener() {

                            @Override
                            public void onDialogItemClick(CBDialogBuilder.DialogItemAdapter ItemAdapter,
                                                          Context context, CBDialogBuilder dialogbuilder, Dialog dialog,
                                                          int position) {
                                curSelectedItemPos = position;
                                //TODO 保存选中设置
                                dialog.dismiss();
                            }
                        }, curSelectedItemPos)
                        .create().show();
                break;
            case R.id.pop_6:
                new CBDialogBuilder(this, CBDialogBuilder.DIALOG_STYLE_PROGRESS, 0.5f)
                        .showCancelButton(true)
                        .setMessage("正在加载请稍后...")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .setOnProgressOutTimeListener(1, new CBDialogBuilder.onProgressOutTimeListener() {
                            @Override
                            public void onProgressOutTime(Dialog dialog, TextView dialogMsgTextView) {
                                dialogMsgTextView.setText("出错啦");
                            }
                        })
                        .create().show();
                break;
            case R.id.pop_7:
                new CBDialogBuilder(this, CBDialogBuilder.DIALOG_STYLE_PROGRESS_TITANIC)
                        .setTouchOutSideCancelable(false)
                        .setDialogBackground(R.drawable.dialog_background_grey)
                        .setConfirmBackgroundResouce(R.drawable.gray_button_background)
                        .showCancelButton(true)
                        .setMessage("正在加载请稍后...")
                        .setProgressTitanicText("拼命加载")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .setOnProgressOutTimeListener(2, new CBDialogBuilder.onProgressOutTimeListener() {
                            @Override
                            public void onProgressOutTime(Dialog dialog, TextView dialogMsgTextView) {

                            }
                        })
                        .create().show();
                break;
            case R.id.pop_8:
                new CBDialogBuilder(this, CBDialogBuilder.DIALOG_STYLE_PROGRESS_AVLOADING)
                        .setTouchOutSideCancelable(false)
                        .showCancelButton(true)
                        .setMessage("正在加载请稍后...")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .setOnProgressOutTimeListener(1, new CBDialogBuilder.onProgressOutTimeListener() {
                            @Override
                            public void onProgressOutTime(Dialog dialog, TextView dialogMsgTextView) {

                            }
                        })
//                        .setProgressIndicatorColor(0xaa198675)
//                        .setProgressIndicator(CBDialogBuilder.INDICATOR_BallGridPulse)
                        .create().show();
                break;
            case R.id.pop_9:
                new CBDialogBuilder(this, R.layout.layout_custom_dialog_layout, 1.0f)
                        .setTouchOutSideCancelable(true)
                        .showCancelButton(false)
                        .setDialoglocation(CBDialogBuilder.DIALOG_LOCATION_BOTTOM)
                        .setTitle("这是一个自定义dialog布局样式的对话框")
                        .setMessage("去除了dialog的圆角背景")
                        .setConfirmButtonText("确定")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .create().show();

                break;
            case R.id.pop_10:
                new CBDialogBuilder(this, CBDialogBuilder.DIALOG_STYLE_NORMAL, 1.0f)
                        .showIcon(false)
                        .setTouchOutSideCancelable(true)
                        .showCancelButton(false)
                        .setDialoglocation(CBDialogBuilder.DIALOG_LOCATION_BOTTOM)
                        .setTitle("这是一个自定义消息布局view的对话框")
                        .setView(R.layout.custom_msg_view)
                        .setConfirmButtonText("确定")
                        .setDialogAnimation(CBDialogBuilder.DIALOG_ANIM_SLID_BOTTOM)
                        .create().show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_public, menu);
        menu.getItem(0).setIcon(R.drawable.anv_omit);
        return super.onCreateOptionsMenu(menu);
    }

}
