package com.example.lib_model.response

class VisitBean {
    /**
     * id : 423646426907066368
     * doctorId : 2
     * userId : db87bf68448647abbdf1f3b85370bc81
     * title : 测试标题
     * sendTime : 1590114540000
     * createTime : 1590114540000
     * recordId : 1
     * isOnceAnswer : true
     * sendRange : 1
     * isRemind : true
     * endTime : 1590114540000
     * status : 1
     * updateTime : 1590114540000
     * isDelete : true
     * qrtfContentParentId : 4
     * artfContentParentId : 4
     */
    var id: String? = null
    var doctorId: String? = null
    var userId: String? = null
    var title: String? = null
    var sendTime: Long = 0
    var createTime: Long = 0
    var recordId: String? = null
    var isIsOnceAnswer = false
        private set
    var sendRange: String? = null
    var isIsRemind = false
        private set
    var endTime: Long = 0
    var status: String? = null
    var updateTime: Long = 0
    var isIsDelete = false
        private set
    var qrtfContentParentId: String? = null
    var artfContentParentId: String? = null

    fun setIsOnceAnswer(isOnceAnswer: Boolean) {
        isIsOnceAnswer = isOnceAnswer
    }

    fun setIsRemind(isRemind: Boolean) {
        isIsRemind = isRemind
    }

    fun setIsDelete(isDelete: Boolean) {
        isIsDelete = isDelete
    }

    override fun toString(): String {
        return "VisitBean(id=$id, doctorId=$doctorId, userId=$userId, title=$title, sendTime=$sendTime, createTime=$createTime, recordId=$recordId, isIsOnceAnswer=$isIsOnceAnswer, sendRange=$sendRange, isIsRemind=$isIsRemind, endTime=$endTime, status=$status, updateTime=$updateTime, isIsDelete=$isIsDelete, qrtfContentParentId=$qrtfContentParentId, artfContentParentId=$artfContentParentId)"
    }

}
