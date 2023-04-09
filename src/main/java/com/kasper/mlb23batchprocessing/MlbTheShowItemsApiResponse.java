package com.kasper.mlb23batchprocessing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MlbTheShowItemsApiResponse implements Serializable {
    private int page;
    private int per_page;
    private int total_pages;
    private List<MlbTheShowMlbCard> items;
}
