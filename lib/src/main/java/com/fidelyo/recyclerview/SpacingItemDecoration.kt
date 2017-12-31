package com.fidelyo.recyclerview

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by bishoy on 8/22/17.
 */

open class SpacingItemDecoration(val spacing: Int) : RecyclerView.ItemDecoration() {

    var skipLookup = object : SkipLookup {
        override fun shouldSkip(position: Int) = false
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        if (skipLookup.shouldSkip(position))
            return
        if (position < 0)
            return
        applySpacing(position, outRect)
    }

    open fun applySpacing(position: Int, outRect: Rect) {

    }

    interface SkipLookup {
        fun shouldSkip(position: Int): Boolean
    }

}
