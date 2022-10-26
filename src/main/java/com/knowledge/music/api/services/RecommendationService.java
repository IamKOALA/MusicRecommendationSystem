package com.knowledge.music.api.services;

import com.knowledge.music.api.model.SongSearchRequest;
import com.knowledge.music.api.model.shazam.recommend.RecommendResponse;

public interface RecommendationService {
    RecommendResponse getRecommendedSongs(SongSearchRequest songSearchRequest);
}
