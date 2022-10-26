package com.knowledge.music.lottery.api.services;

import com.knowledge.music.lottery.api.model.SongSearchRequest;
import com.knowledge.music.lottery.api.model.shazam.recommend.RecommendResponse;

public interface RecommendationService {
    RecommendResponse getRecommendedSongs(SongSearchRequest songSearchRequest);
}
