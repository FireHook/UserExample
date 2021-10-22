package com.android.app.userexample.view.recycler_adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.app.userexample.R
import com.android.app.userexample.view.base.BaseAdapter
import com.android.app.userexample.view.entity.UserEntity
import com.android.app.userexample.view.recycler_adapter.UserListAdapter.*

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
class UserListAdapter(
    private val listener: UserClickListener
): BaseAdapter<ViewHolder, UserEntity>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(inflate(parent, R.layout.item_user_list))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val nameTv = view.findViewById<TextView>(R.id.name_tv)
        private val userNameTv = view.findViewById<TextView>(R.id.username_tv)

        fun bind(userEntity: UserEntity) {
            with(userEntity) {
                nameTv.text = name
                userNameTv.text = username
            }
            itemView.setOnClickListener {
                listener.onUserClicked(userEntity.id)
            }
        }
    }

    interface UserClickListener {
        fun onUserClicked(id: Int)
    }
}