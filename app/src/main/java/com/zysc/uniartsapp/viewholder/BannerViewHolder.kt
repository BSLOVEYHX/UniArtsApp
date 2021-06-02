package com.zysc.uniartsapp.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.zhouwei.mzbanner.holder.MZViewHolder
import com.zysc.uniartsapp.R
import com.zysc.uniartsapp.bean.Banners

/**
 *@Date:2021/6/2
 *@Author:Created by peter_ben
 */
class BannerViewHolder : MZViewHolder<Banners> {

    private lateinit var mImgView : ImageView

    override fun createView(context: Context?): View {
        val view  = LayoutInflater.from(context).inflate(R.layout.item_banner,null)
        mImgView = view.findViewById(R.id.banner_image)
        return view
    }

    override fun onBind(context: Context?, position: Int, data: Banners?) {
        if (context != null) {
            Glide.with(context).clear(mImgView)
            if(data != null){
                Glide.with(context).load(data.img_middle)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(mImgView)
            }
        }
        mImgView.setOnClickListener {

        }
    }
}