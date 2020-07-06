package com.sample.newsapp.news.ui.activity

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.sample.newsapp.R
import com.sample.newsapp.core.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_news_detail.*


class NewsDetailActivity: BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        getDataFromIntent()
    }

    /**
     * get url of the news item and open in web view
     */

    private fun getDataFromIntent(){
        if(intent!=null){
            val url = intent.getStringExtra("url")
            webview.settings.javaScriptEnabled = true
            webview.webViewClient = WebViewController()
            webview.loadUrl(url)

        }
    }


    class WebViewController : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }



}