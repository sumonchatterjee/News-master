package com.sample.newsapp.news.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sample.newsapp.news.model.NewsArticles
import com.sample.newsapp.core.ui.ViewState
import com.sample.newsapp.news.domain.NewsRepository
import javax.inject.Inject

/**
 * A container for [NewsArticles] related data to show on the UI.
 */
class NewsArticleViewModel @Inject constructor(
        newsRepository: NewsRepository
) : ViewModel() {

    private val newsArticles: LiveData<ViewState<List<NewsArticles>>> = newsRepository.getNewsArticles().asLiveData()

    /**
     * Return news articles to observeNotNull on the UI.
     */
    fun getNewsArticles(): LiveData<ViewState<List<NewsArticles>>> = newsArticles



}