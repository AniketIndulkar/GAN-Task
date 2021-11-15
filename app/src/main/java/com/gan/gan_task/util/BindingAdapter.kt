package com.gan.gan_task.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gan.gan_task.R

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(R.drawable.ic_launcher_background)
            .into(view)
    }else{
        view.setImageResource(R.drawable.ic_launcher_background)
    }
}

@BindingAdapter("imageFromIsFav")
fun bindImageFromIsFav(view: ImageView, isFav: Boolean) {
    if (isFav) {
        view.setImageResource(R.drawable.ic_filled_star)
    }else{
        view.setImageResource(R.drawable.ic_star)
    }
}