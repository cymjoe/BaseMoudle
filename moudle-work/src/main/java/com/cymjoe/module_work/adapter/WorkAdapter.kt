package com.cymjoe.module_work.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.cymjoe.lib_model.response.BannerEntity
import com.cymjoe.module_work.R
import com.cymjoe.module_work.entity.HomeEntity
import com.youth.banner.Banner
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator

class WorkAdapter(data: MutableList<HomeEntity>) :
    BaseMultiItemQuickAdapter<HomeEntity, BaseViewHolder>(data) {
    init {
        addItemType(0, R.layout.item_home_banner)
        addItemType(1, R.layout.item_home_banner_middle)
        addItemType(2, R.layout.item_home_btn)
        addItemType(3, R.layout.item_home_chat)
    }

    override fun convert(holder: BaseViewHolder, item: HomeEntity) {
        when (holder.itemViewType) {
            0 -> {
                val banner = holder.getView(R.id.banner) as Banner<*, *>
                banner.adapter = ImagesAdapter(item.data)
                banner.setIndicator(CircleIndicator(context))
                    .setIndicatorGravity(IndicatorConfig.Direction.CENTER)
            }
            1 -> {
            }
            2 -> {
            }
            3 -> {
            }
        }

    }
}