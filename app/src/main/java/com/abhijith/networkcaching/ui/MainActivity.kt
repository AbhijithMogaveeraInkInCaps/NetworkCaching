package com.abhijith.networkcaching.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.abhijith.networkcaching.R
import com.abhijith.networkcaching.api.RetrofitInstance
import com.abhijith.networkcaching.api.models.Main
import com.abhijith.networkcaching.db.PostDatabase
import com.abhijith.networkcaching.repo.PostRepo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repo = PostRepo(PostDatabase(this@MainActivity)).getLatestPost().observe(this@MainActivity,{
            it.forEach {
                Log.e("DIV", it.postLD.post_id)
                it.postList.forEach {
                    Log.e("DIV---->", it.seq)
                }
            }
        })
    }
}