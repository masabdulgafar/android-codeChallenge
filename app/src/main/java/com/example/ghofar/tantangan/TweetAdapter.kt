package id.logivity.binarrecyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ghofar.tantangan.R
import com.example.ghofar.tantangan.Tweet
import kotlinx.android.synthetic.main.item_android.view.*
import kotlinx.android.synthetic.main.item_android.view.*

class TweetAdapter: RecyclerView.Adapter<TweetAdapter.ViewHolder>() {

    private lateinit var ctx: Context
    private val tweetList = mutableListOf<Tweet>()

    fun addTweetList(tweets: MutableList<Tweet>) {
        tweetList.clear()
        tweetList.addAll(tweets)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        ctx = viewGroup.context
        val itemView = LayoutInflater.from(ctx).inflate(R.layout.item_android, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return tweetList.count()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                Toast.makeText(ctx, "Tweet clicked $adapterPosition", Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(position: Int) {
            val tweet = tweetList[position]
            itemView.id_android.text = tweet.nama
            itemView.id_versi_android.text = tweet.versi
            itemView.id_api_level.text = tweet.apilevel
            itemView.rombongan.setOnClickListener {
                Toast.makeText(ctx, "Image clicked $position", Toast.LENGTH_SHORT).show()
            }
        }
    }
}





















