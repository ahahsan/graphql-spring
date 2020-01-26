package org.aha.graphql.adapter.graphql.model;

import lombok.Data;


@Data
public class ImageUpload {
    private  String name;
    private  String productId;
    private String tenant;
    private  String title;
    private  String locale;
    private  String payload;
}
