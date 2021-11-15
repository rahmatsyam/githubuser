package com.github.githubuserdicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.githubuserdicoding.data.getDataUser
import com.github.githubuserdicoding.data.model.UsersItem
import com.github.githubuserdicoding.databinding.ActivityMainBinding
import com.github.githubuserdicoding.ui.ClickItemUser
import com.github.githubuserdicoding.ui.DetailUserActivity
import com.github.githubuserdicoding.ui.adapter.UserAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRV()
    }

    private fun setRV() {
        val itemData = getDataUser()
        val itemAdapter = itemData?.users?.let { UserAdapter(it, this) }
        binding.rvGithub.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = itemAdapter
        }

        itemAdapter?.setClickItem(object : ClickItemUser {
            override fun itemClicked(model: UsersItem) {
                val intentUserData = Intent(this@MainActivity, DetailUserActivity::class.java)
                intentUserData.putExtra(USER, model)
                startActivity(intentUserData)
            }

        })

    }

    companion object {
       const val USER = "user"
    }


}