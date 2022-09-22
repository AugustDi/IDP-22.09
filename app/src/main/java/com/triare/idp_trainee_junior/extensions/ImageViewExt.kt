package com.triare.idp_trainee_junior.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.load(
    url: String?
) {
    loadUrl(
        url
    )
}

private fun ImageView.loadUrl(
    url: String?,
) {
    val builder = Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)

    builder.into(this)
}