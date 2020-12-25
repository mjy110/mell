package com.example.firsttest.adapterlibrary;

import android.content.Context;
import android.media.Image;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public
/*
修改       确认修改
*/   class ImageUtils {
    public static void loadimage(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }
}
