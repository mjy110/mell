package com.example.firsttest.adapterlibrary;

public
/*
修改       确认修改
*/ interface CommonType<DATA> {
    //根据不同的类型返回对应的布局文件
    int getTypeLayoutId(int viewType);
    //返回类型
    int getType(int positon, DATA data);
}