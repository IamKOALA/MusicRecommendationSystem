package com.knowledge.music.lottery.impl.services;

import com.knowledge.music.lottery.api.model.shazam.recommend.RecommendResponse;
import com.knowledge.music.lottery.api.model.SongSearchRequest;
import com.knowledge.music.lottery.api.services.RecommendationService;
import com.knowledge.music.lottery.api.services.ShazamApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DefaultRecommendationService implements RecommendationService {

    @Autowired
    private ShazamApi shazamApiClient;

    @Override
    public RecommendResponse getRecommendedSongs(SongSearchRequest songSearchRequest) {
        System.out.println("HORAY");

        Long key = shazamApiClient.executeSearchRequest(songSearchRequest);

        RecommendResponse resp = shazamApiClient.getRecommendationList(key);

        resp.getTracks().forEach(track -> {
            track.getHub().getActions().removeIf(it -> {
                return it.uri == null;
            });
        });

        return resp;
    }
}
