package aha.graphql.adapter.graphql.model;

import lombok.Data;

@Data
public class ScreenshotInfo {
    private String title;
    private String productId;
    private String locale;
    private ImageInfo image1x;
    private ImageInfo image2x;
}
