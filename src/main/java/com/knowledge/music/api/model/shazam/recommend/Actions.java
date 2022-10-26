package com.knowledge.music.api.model.shazam.recommend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Actions {
    public String name;
    public String type;
    public String uri;
    public String id;
}
