package com.sample.newsapp.news.api

import com.sample.newsapp.BuildConfig
import com.sample.newsapp.news.model.NewsSourceResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Fetch all the latest news article from various news services
 * using the News API.
 */
interface NewsService {

    /**
     * Retrieves all the top headlines using News API.
     */
    @GET("top-headlines?country=us&apiKey=${BuildConfig.NEWS_API_KEY}")
    suspend fun getNewsFromGoogle(): Response<NewsSourceResponse>

}
