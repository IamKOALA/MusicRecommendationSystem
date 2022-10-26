package com.knowledge.music.lottery.api.services;

import com.knowledge.music.lottery.api.model.SongSearchRequest;
import com.knowledge.music.lottery.api.model.shazam.recommend.RecommendResponse;

public interface ShazamApi {

    public Long executeSearchRequest(SongSearchRequest request);

    public RecommendResponse getRecommendationList(Long key);
}
