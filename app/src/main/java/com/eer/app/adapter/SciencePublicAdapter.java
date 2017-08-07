package com.eer.app.adapter;

import com.eer.app.entity.SciencePublicEntity;
import com.em.baseframe.adapter.recyclerview.BaseQuickAdapter;
import com.em.baseframe.adapter.recyclerview.BaseViewHolder;

import java.util.List;

/**
 * @title  科普文献通用适配器
 * @date   2017/06/17
 * @author enmaoFu
 */
public class SciencePublicAdapter extends BaseQuickAdapter<SciencePublicEntity,BaseViewHolder>{

    public SciencePublicAdapter(int layoutResId, List<SciencePublicEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SciencePublicEntity item) {

    }
}
