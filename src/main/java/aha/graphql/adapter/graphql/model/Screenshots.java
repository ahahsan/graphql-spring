package aha.graphql.adapter.graphql.model;

import lombok.Data;

import java.util.List;


@Data
public class Screenshots {
    private String productId;
    private List<ScreenshotInfo> localised;
}
