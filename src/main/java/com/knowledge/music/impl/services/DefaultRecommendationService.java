package com.knowledge.music.impl.services;

import com.knowledge.music.api.model.shazam.recommend.RecommendResponse;
import com.knowledge.music.api.model.SongSearchRequest;
import com.knowledge.music.api.services.RecommendationService;
import com.knowledge.music.api.services.ShazamApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DefaultRecommendationService implements RecommendationService {

    @Autowired
    private ShazamApi shazamApiClient;

    @Override
    public RecommendResponse getRecommendedSongs(SongSearchRequest songSearchRequest) {
        Long key = shazamApiClient.executeSearchRequest(songSearchRequest);

        RecommendResponse resp = shazamApiClient.getRecommendationList(key);

        convertResponse(resp);

        return resp;
    }

    private void convertResponse(RecommendResponse resp) {
        resp.getTracks().forEach(track -> {
            track.getHub().getActions().removeIf(it -> it.uri == null);
        });
    }
}
