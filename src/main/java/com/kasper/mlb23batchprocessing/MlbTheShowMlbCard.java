package com.kasper.mlb23batchprocessing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MlbTheShowMlbCard implements Serializable {
    private String uuid;
    private String name;
    private String rarity;
    private String team;
    private int ovr;
    private String img;
}
