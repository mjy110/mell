package com.example.firsttest.adapterlibrary;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public
/*
修改       确认修改
*/  abstract class BaseAdapter<DATA> extends RecyclerView.Adapter<BaseViewHolder>{
    protected List<DATA> datas;
    protected Context context;
     protected LayoutInflater inflater;
    private int layoutId;

    public BaseAdapter(List<DATA> datas, Context context, int layoutId) {
        this.datas = datas;
        this.context = context;
       inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
    }
    public void setData(List<DATA> datas){
        this.datas=(datas);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseViewHolder(inflater.inflate(layoutId,parent,false),context);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
        bindData(holder,position);
        holder.getRootVIew().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adapterOnItemClickListener!=null) {
                    adapterOnItemClickListener.OnItemClick(position);
                }
            }
        });
    }
    public abstract void bindData(BaseViewHolder baseViewHolder,int position);
    @Override
    public int getItemCount() {
        return datas.size();
    }
    public interface AdapterOnItemClickListener{
        void OnItemClick(int postion);
    }
    private AdapterOnItemClickListener adapterOnItemClickListener;

    public void setAdapterOnItemClickListener(AdapterOnItemClickListener adapterOnItemClickListener) {
        this.adapterOnItemClickListener = adapterOnItemClickListener;
    }
}
