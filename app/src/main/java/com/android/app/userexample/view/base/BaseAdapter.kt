package com.android.app.userexample.view.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
abstract class BaseAdapter<T : RecyclerView.ViewHolder, E> : RecyclerView.Adapter<T>(),
    BindableAdapter<E> {

    protected val items = mutableListOf<E>()

    override fun getItemCount() = items.size

    fun addToTop(item: E) {
        this.items.add(firstPosition(), item)
        notifyItemInserted(firstPosition())
    }

    fun remove(position: Int) {
        this.items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun setAll(items: List<E>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addAllToBottom(items: List<E>) {
        this.items.addAll(items)
        notifyItemRangeInserted(lastPosition(), items.size)
    }

    override fun setData(items: List<E>?) {
        items?.let { setAll(it) }
    }

    fun firstPosition() = 0

    fun lastPosition() = items.size - 1

    fun inflate(parent: ViewGroup, layoutId: Int) = LayoutInflater.from(parent.context).inflate(
        layoutId,
        parent,
        false
    )
}