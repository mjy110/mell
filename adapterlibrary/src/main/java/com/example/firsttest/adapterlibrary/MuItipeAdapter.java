package com.example.firsttest.adapterlibrary;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

public
/*
修改       确认修改
*/ abstract  class MuItipeAdapter<DATA> extends BaseAdapter<DATA> {
    private CommonType<DATA> commonType;
    protected int type;
    public MuItipeAdapter(List<DATA> datas, Context context, int layoutId,CommonType<DATA> commonType) {
        super(datas, context, layoutId);
        if(layoutId==0){
            this.commonType=commonType;
        }
    }
    public int getItemViewType(int position){
        type=commonType.getType(position,datas.get(position));
        return type;
    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        int layoutId = commonType.getTypeLayoutId(type);
        return new BaseViewHolder(inflater.inflate(layoutId,viewGroup,false),context);
    }
}
