package com.abhijith.networkcaching.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.abhijith.networkcaching.R
import com.abhijith.networkcaching.adapters.RecyclerViewAdapter
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
        val recyclerViewAdapter = RecyclerViewAdapter(listOf())
        findViewById<RecyclerView>(R.id.rv).apply {
            adapter = recyclerViewAdapter
        }
        PostRepo(PostDatabase(this@MainActivity)).getLatestPost().observe(this@MainActivity, {
            Toast.makeText(this, "call recieved", Toast.LENGTH_SHORT).show()
            runOnUiThread {
                findViewById<RecyclerView>(R.id.rv).apply {
                    adapter = RecyclerViewAdapter(it)
                }
            }
        })
    }
}