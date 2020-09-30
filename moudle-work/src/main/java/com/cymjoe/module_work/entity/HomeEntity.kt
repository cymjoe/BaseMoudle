package com.cymjoe.module_work.entity

import androidx.annotation.Keep
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.cymjoe.lib_model.response.BannerEntity
import java.util.*
@Keep
class HomeEntity(override var itemType: Int) : MultiItemEntity {
    var data: List<BannerEntity>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

}