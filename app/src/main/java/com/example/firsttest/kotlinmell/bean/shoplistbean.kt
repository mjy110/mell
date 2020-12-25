package com.example.firsttest.kotlinmell.bean


class shoplistbean {
    /**
     * status : 0
     * message : 列表获取成功
     * data : [{"id":9,"categoryId":24,"goodsDesc":"Apple iPhone 6s Plus (A1699) 32G 金色 移动联通电信4G手机","goodsDefaultIcon":"https://img14.360buyimg.com/n1/s450x450_jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg","goodsDefaultPrice":"100","goodsDetailOne":"https://img30.360buyimg.com/jgsq-productsoa/jfs/t6337/310/2148869366/61744/dca36a9c/595dda76N64984138.jpg","goodsDetailTwo":"https://img30.360buyimg.com/jgsq-productsoa/jfs/t6175/244/140312464/88326/30e3b943/593a4888N3187bea7.jpg","goodsSalesCount":9890,"goodsStockCount":1200,"goodsCode":"10000000010","goodsDefaultSku":"金色,32GB,1件","maxPage":1},{"id":10,"categoryId":24,"goodsDesc":"Apple iPhone 7 Plus (A1661) 32G 亮黑色 移动联通电信4G手机","goodsDefaultIcon":"https://img14.360buyimg.com/n1/s450x450_jfs/t3064/188/1693292264/115570/e891640b/57d11bfaN2e8acade.jpg","goodsDefaultPrice":"200","goodsDetailOne":"https://img30.360buyimg.com/jgsq-productsoa/jfs/t6337/310/2148869366/61744/dca36a9c/595dda76N64984138.jpg","goodsDetailTwo":"https://img30.360buyimg.com/jgsq-productsoa/jfs/t6175/244/140312464/88326/30e3b943/593a4888N3187bea7.jpg","goodsSalesCount":12313,"goodsStockCount":12566,"goodsCode":"10000000011","goodsDefaultSku":"亮黑色,32GB,1件","maxPage":1},{"id":11,"categoryId":24,"goodsDesc":"苹果 Apple iPhone 6 4G手机 灰色 公开全网通(32G)标配","goodsDefaultIcon":"https://img14.360buyimg.com/n1/s450x450_jfs/t5581/37/6255093126/256134/d8ae5c1d/59688753N177cfc26.jpg","goodsDefaultPrice":"100","goodsDetailOne":"https://img30.360buyimg.com/popWaterMark/jfs/t3016/136/650115357/171206/c66b2965/57ad8acaN57ed9319.jpg","goodsDetailTwo":"https://img30.360buyimg.com/popWaterMark/jfs/t2935/12/2469495182/65696/a31dc72e/57ad8acaNef46eb26.jpg","goodsSalesCount":56667,"goodsStockCount":8434,"goodsCode":"10000000012","goodsDefaultSku":"灰色,32GB,1件","maxPage":1}]
     */
    var status = 0
    var message: String? = null
    var data: List<DataBean>? = null

    class DataBean {
        /**
         * id : 9
         * categoryId : 24
         * goodsDesc : Apple iPhone 6s Plus (A1699) 32G 金色 移动联通电信4G手机
         * goodsDefaultIcon : https://img14.360buyimg.com/n1/s450x450_jfs/t3268/124/2646283367/114153/f5704b88/57e4a358N9ccc6645.jpg
         * goodsDefaultPrice : 100
         * goodsDetailOne : https://img30.360buyimg.com/jgsq-productsoa/jfs/t6337/310/2148869366/61744/dca36a9c/595dda76N64984138.jpg
         * goodsDetailTwo : https://img30.360buyimg.com/jgsq-productsoa/jfs/t6175/244/140312464/88326/30e3b943/593a4888N3187bea7.jpg
         * goodsSalesCount : 9890
         * goodsStockCount : 1200
         * goodsCode : 10000000010
         * goodsDefaultSku : 金色,32GB,1件
         * maxPage : 1
         */
        var id = 0
        var categoryId = 0
        var goodsDesc: String? = null
        var goodsDefaultIcon: String? = null
        var goodsDefaultPrice: String? = null
        var goodsDetailOne: String? = null
        var goodsDetailTwo: String? = null
        var goodsSalesCount = 0
        var goodsStockCount = 0
        var goodsCode: String? = null
        var goodsDefaultSku: String? = null
        var maxPage = 0

    }

    override fun toString(): String {
        return "aaa{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}'
    }
}
