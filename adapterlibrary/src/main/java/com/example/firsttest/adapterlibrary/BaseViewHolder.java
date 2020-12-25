package com.example.firsttest.adapterlibrary;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public
/*
修改       确认修改
*/   class BaseViewHolder extends RecyclerView .ViewHolder{
    private View rootView;
    private SparseArray<View> mViews=new SparseArray<>();
    private Context context;

    public BaseViewHolder(@NonNull View itemView,Context context) {
        super(itemView);
        rootView= itemView;
        this.context=context;
    }
    public View getRootVIew(){
        return rootView;
    }
    public <T extends View> T getView(int ViewId){
        T view=null;
        if(mViews.get(ViewId)!=null){
            view=(T) mViews.get(ViewId);
        }else{
            view=rootView.findViewById(ViewId);
            mViews.put(ViewId,view);
        }
        return view;
    }
    public BaseViewHolder settext(int viewid,String text){
        TextView textView=getView(viewid);
        textView.setText(text);
        return this;
    }
    public BaseViewHolder setText(int viewid,final String text,final
     AdapterOnItemViewClickListener<String> adapterOnItemViewClickListener){
        TextView textView=getView(viewid);
        textView.setText(text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterOnItemViewClickListener.OnItemClick(text);
            }
        });
        return this;
    }
    public BaseViewHolder setimage(int viewid,String url){
        ImageView imageView=getView(viewid);
        ImageUtils.loadimage(context,url,imageView);
        return this;
    }
    public interface AdapterOnItemViewClickListener<T>{
        void OnItemClick(T t);
    }
}
