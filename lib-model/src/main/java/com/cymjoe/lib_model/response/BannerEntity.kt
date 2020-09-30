package com.cymjoe.lib_model.response

import android.text.TextUtils
import androidx.annotation.Keep

/**
 * Place：Chengdu,China
 * Project：KlilalaLifeService
 * Version：V1.0.0
 * CreatedBy: Samiu 2020/5/27
 * Description:
 * Copyright©2020 Past Present Future. All Rights Reserved
 */
@Keep
class BannerEntity(
    /**
     * 主键
     */
    var id: String? = null,

    /**
     * 广告内容名称
     */
    var name: String? = null,

    /**
     * 封面
     */
    var cover: String? = null,

    /**
     * 跳转 图片/视频（废弃）
     */
    var type: String? = null,

    /**
     * 跳转的内容（医生主键/团队主键/文章主键/URL信息）
     */
    var src: String? = null,

    /**
     * （废弃字段）
     */
    var dueTime: Long = 0,

    /**
     * （废弃字段）
     */
    var weight: Double = 0.0,

    /**
     * （废弃字段）
     */
    var paramJson: String? = null,

    /**
     * 启用  禁用（废弃字段）
     */
    var isStatus: Boolean = false,

    /**
     * 展示位置编码
     */
    var positionCode: String? = null,

    /**
     * 跳转类型（URL/文章/医生/团队)
     */
    var jumpType: String? = "",

    /**
     * 创建时间
     */
    var createTime: Long = 0,

    /**
     * 更新时间
     */
    var updateTime: Long = 0,

    /**
     * 是否删除
     */
    var isDelete: Boolean = false

)