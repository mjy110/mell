package com.example.firsttest.kotlinmell.bean


/*
修改       确认修改
*/   class registbean {
    /**
     * status : -1
     * message : 账号已被注册
     */
    var status = 0
    var message: String? = null

    override fun toString(): String {
        return "aa{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}'
    }
}
