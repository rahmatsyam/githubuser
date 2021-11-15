package com.github.githubuserdicoding.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.githubuserdicoding.MainActivity
import com.github.githubuserdicoding.data.model.UsersItem
import com.github.githubuserdicoding.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val user = intent.getParcelableExtra<UsersItem>(MainActivity.USER) as UsersItem

        getUserDetail(user)


    }

    @SuppressLint("SetTextI18n")
    private fun getUserDetail(model: UsersItem) {
        binding.apply {
            tvName.text = model.name
            tvUsername.text = "@${model.username}"
            tvTotalFollowers.text = model.follower.toString()
            tvTotalFollowing.text = model.following.toString()
            tvTotalRepository.text = model.repository.toString()
            tvLocation.text = model.location
            tvCompany.text = model.company

            val image = resources.getIdentifier(model.avatar, null, packageName)

            ivUser.setImageResource(image)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}