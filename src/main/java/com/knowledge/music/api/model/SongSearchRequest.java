package com.knowledge.music.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SongSearchRequest {
    public String songName;
    public String author;
}
