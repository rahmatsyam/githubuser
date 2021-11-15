package com.github.githubuserdicoding.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.githubuserdicoding.data.model.UsersItem
import com.github.githubuserdicoding.databinding.ItemUserBinding
import com.github.githubuserdicoding.ui.ClickItemUser

class UserAdapter(private val userList: List<UsersItem>, private val context: Context) :
    RecyclerView.Adapter<UserViewHolder>() {

    private lateinit var mListener : ClickItemUser

    fun setClickItem(listener:ClickItemUser){
        this.mListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindTo(userList[position], context, mListener)
    }

    override fun getItemCount(): Int = userList.size
}