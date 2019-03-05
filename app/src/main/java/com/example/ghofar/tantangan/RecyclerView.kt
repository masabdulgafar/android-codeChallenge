package com.example.ghofar.tantangan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import com.example.ghofar.tantangan.R.id.btn_logout
import id.logivity.binarrecyclerview.TweetAdapter
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerView : AppCompatActivity() {

    private lateinit var appData: AppDataPreferences
    private lateinit var tweetAdapter:TweetAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        setupComponent()
        setupCompoo()
        addDummyData()

    }
    private fun setupComponent(){
        tweetAdapter = TweetAdapter()
        rv_binar_app.setHasFixedSize(true)
        rv_binar_app.layoutManager = LinearLayoutManager(this)
        rv_binar_app.adapter = tweetAdapter
    }
    private fun addDummyData(){
        val tweetList = mutableListOf<Tweet>()
        tweetList.add(Tweet("Alpha","android 1","API Level 1"))
        tweetList.add(Tweet("Beta","android 1.1", "API Level 2"))
        tweetList.add(Tweet("Cupcake","android 1.5","API Level 3"))
        tweetList.add(Tweet("Donut","android 1.6","API Level 4"))
        tweetList.add(Tweet("Eclair","android 2.0", "API Level 5"))
        tweetList.add(Tweet("Eclair","android 2.0.1", "API Level 6"))
        tweetList.add(Tweet("Eclair","android 2.1", "API Level 7"))
        tweetList.add(Tweet("Froyo","android 2.2","API Level 8"))
        tweetList.add(Tweet("Gingerbread","android 2.3.2","API Level 9"))
        tweetList.add(Tweet("Gingerbread","android 2.3.7","API Level 10"))
        tweetList.add(Tweet("Honeycomb","android 3.0", "API Level 11"))
        tweetList.add(Tweet("Honeycomb","android 3.1", "API Level 12"))
        tweetList.add(Tweet("Honeycomb","android 3.2", "API Level 13"))
        tweetList.add(Tweet("Ice Cream Sandwich","android 4.0.2","API Level 14"))
        tweetList.add(Tweet("Ice Cream Sandwich","android 4.0.3","API Level 15"))
        tweetList.add(Tweet("Jelly Bean","android 4.1", "API Level 16"))
        tweetList.add(Tweet("Jelly Bean","android 4.2", "API Level 17"))
        tweetList.add(Tweet("Jelly Bean","android 4.3", "API Level 18"))
        tweetList.add(Tweet("Kitkat","android 4.4","API Level 19"))
        tweetList.add(Tweet("Lollipop","android 5.0","API Level 21"))
        tweetList.add(Tweet("Marsmallow","android 6.0", "API Level 23"))
        tweetList.add(Tweet("Nougat","android 7","API Level 24"))
        tweetList.add(Tweet("Oreo","android 8","API Level 25"))
        tweetList.add(Tweet("Binar","android 9", "API Level 29"))

        tweetAdapter.addTweetList(tweetList)
    }


    private fun setupCompoo() {
        appData = AppDataPreferences(this)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.btn_logout -> {
                appData.cleanUserData()
                startActivity(Intent(this@RecyclerView,MainActivity::class.java))
                isFinishing
            }
           else -> super.onOptionsItemSelected(item)
        }
    }

}



