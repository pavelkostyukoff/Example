

package com.poul.android.test.presentation.fragment.extensions

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.poul.android.test.R

fun ImageView.load(imageAddress: String, onClick: (() -> Unit)? = null) {
  val imageView = this
  Glide.with(this)
      .asBitmap()
      .load(imageAddress)
      .placeholder(R.drawable.corner_background)
      .error(R.drawable.splash_background)
      .transition(withCrossFade())
      .into(object : CustomTarget<Bitmap>() {
        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
          imageView.apply {
            setImageBitmap(resource)
            setOnClickListener {
              onClick?.invoke()
            }
          }
        }

        override fun onLoadCleared(placeholder: Drawable?) {
          // Do nothing
        }
      }

      )
}