package com.sample.newsapp.news.ui.adapter

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.sample.newsapp.R
import com.sample.newsapp.core.utils.inflate
import com.sample.newsapp.news.model.NewsArticles
import com.sample.newsapp.news.ui.activity.NewsDetailActivity
import com.sample.newsapp.news.ui.model.NewsAdapterEvent
import kotlinx.android.synthetic.main.row_news_article.view.*

/**
 * The News adapter to show the news in a list.
 */
class NewsArticlesAdapter(
        private val listener: (NewsAdapterEvent) -> Unit) : ListAdapter<NewsArticles, NewsArticlesAdapter.NewsHolder>(DIFF_CALLBACK) {

    /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsHolder(parent.inflate(R.layout.row_news_article))

    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(newsHolder: NewsHolder, position: Int) = newsHolder.bind(getItem(position), listener)

    /**
     * View Holder Pattern
     */
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(newsArticle: NewsArticles, listener: (NewsAdapterEvent) -> Unit) = with(itemView) {
            newsTitle.text = newsArticle.title
            newsAuthor.text = newsArticle.author
            //TODO: need to format date
            //tvListItemDateTime.text = getFormattedDate(newsArticle.publishedAt)
            newsPublishedAt.text = newsArticle.publishedAt
            newsImage.load(newsArticle.urlToImage) {
                placeholder(R.drawable.tools_placeholder)
                error(R.drawable.tools_placeholder)
            }
           // setOnClickListener { listener(NewsAdapterEvent.ClickEvent) }
            itemView.setOnClickListener { navigateNext(newsArticle.url) }
        }


        fun navigateNext(url:String?){
            if(!url.isNullOrEmpty()){

                val intent = Intent(itemView.context,NewsDetailActivity::class.java);
                intent.putExtra("url", url)
                itemView.context.startActivity(intent)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NewsArticles>() {
            override fun areItemsTheSame(oldItem: NewsArticles, newItem: NewsArticles): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: NewsArticles, newItem: NewsArticles): Boolean = oldItem == newItem
        }
    }
}