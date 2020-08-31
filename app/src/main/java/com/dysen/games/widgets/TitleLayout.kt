package com.dysen.games.widgets

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.dysen.games.R
import kotlinx.android.synthetic.main.layout_top.view.*

/**
 * dysen.
 * dy.sen@qq.com    2020/6/14  11:14

 * Info：自定义标题布局
 */
class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.layout_top, this)

        tv_back.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
    }
}