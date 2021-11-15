package com.github.githubuserdicoding.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.github.githubuserdicoding.data.model.UsersItem
import com.github.githubuserdicoding.databinding.ItemUserBinding
import com.github.githubuserdicoding.ui.ClickItemUser

class UserViewHolder(binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    private val mBinding: ItemUserBinding = binding

    fun bindTo(model: UsersItem,context: Context, listnener : ClickItemUser) {
        mBinding.apply {
            tvName.text = model.name
            tvLocation.text = model.location

            val image = context.resources.getIdentifier(model.avatar, null, context.packageName)

            ivUser.setImageResource(image)

            cvUser.setOnClickListener {
                listnener.itemClicked(model)
            }
        }
    }


}