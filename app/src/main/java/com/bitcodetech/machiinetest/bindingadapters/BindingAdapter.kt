package com.bitcodetech.machiinetest.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bitcodetech.machiinetest.R
import com.bumptech.glide.Glide


@BindingAdapter("image_url")
fun loadImageUrlToImageView(imageView: ImageView, value : String) {
    Glide.with(imageView)
        .load(value)
        .circleCrop()
        .error(R.mipmap.ic_launcher)
        .placeholder(R.mipmap.ic_launcher)
        .into(imageView)
}