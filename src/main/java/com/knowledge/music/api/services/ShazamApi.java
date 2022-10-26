package com.knowledge.music.api.services;

import com.knowledge.music.api.model.SongSearchRequest;
import com.knowledge.music.api.model.shazam.recommend.RecommendResponse;

public interface ShazamApi {

    public Long executeSearchRequest(SongSearchRequest request);

    public RecommendResponse getRecommendationList(Long key);
}
