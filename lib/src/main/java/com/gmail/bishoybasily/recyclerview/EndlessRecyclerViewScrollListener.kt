package com.gmail.bishoybasily.recyclerview

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by bishoy on 7/15/17.
 */

abstract class EndlessRecyclerViewScrollListener : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

        super.onScrolled(recyclerView, dx, dy)

        var applicable = false
        var lastVisible = 0
        val visibleThreshold = 3

        val manager = recyclerView.layoutManager
        if (manager != null) {

            val totalItemCount = manager.itemCount

            if (manager is GridLayoutManager) {
                applicable = true
                val layoutManager = manager
                lastVisible = layoutManager.findLastCompletelyVisibleItemPosition()
            }

            if (manager is LinearLayoutManager) {
                applicable = true
                val layoutManager = manager
                lastVisible = layoutManager.findLastCompletelyVisibleItemPosition()
            }

            if (applicable && totalItemCount <= lastVisible + visibleThreshold) {
                recyclerView.post { this.onLoadMore() }
            }
        }
    }

    abstract fun onLoadMore()

}