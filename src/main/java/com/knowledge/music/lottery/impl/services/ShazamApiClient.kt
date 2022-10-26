package com.knowledge.music.lottery.impl.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.knowledge.music.lottery.api.model.SongSearchRequest
import com.knowledge.music.lottery.api.model.shazam.recommend.RecommendResponse
import com.knowledge.music.lottery.api.model.shazam.search.SearchResponse
import com.knowledge.music.lottery.api.services.ShazamApi
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service


@Service
class ShazamApiClient(): ShazamApi {

    override fun executeSearchRequest(request: SongSearchRequest): Long {
        val client = OkHttpClient()
        val objectMapper = ObjectMapper()

        val term = request.songName.replace(" ", "%20")

        val request = Request.Builder()
                .url("https://shazam.p.rapidapi.com/search?term=${term}&locale=en-US&offset=0&limit=5")
                .get()
                .addHeader("X-RapidAPI-Key", "f196d211ccmsh3f53d6611066297p192f25jsn0eab0a6b6c65")
                .addHeader("X-RapidAPI-Host", "shazam.p.rapidapi.com")
                .build()

        val responseBody = client.newCall(request).execute().body?.string()

        val searchResponse = objectMapper.readValue(responseBody, SearchResponse::class.java)

        return searchResponse.tracks.hits[0].track.key
    }

    override fun getRecommendationList(key: Long): RecommendResponse {
        val client = OkHttpClient()
        val objectMapper = ObjectMapper()

        val request = Request.Builder()
                .url("https://shazam.p.rapidapi.com/songs/list-recommendations?key=$key&locale=en-US")
                .get()
                .addHeader("X-RapidAPI-Key", "f196d211ccmsh3f53d6611066297p192f25jsn0eab0a6b6c65")
                .addHeader("X-RapidAPI-Host", "shazam.p.rapidapi.com")
                .build()

        val responseBody = client.newCall(request).execute().body?.string()

        val recommendationList = objectMapper.readValue(responseBody, RecommendResponse::class.java)

        return recommendationList
    }

}