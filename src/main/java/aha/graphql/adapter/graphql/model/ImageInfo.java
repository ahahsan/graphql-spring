package aha.graphql.adapter.graphql.model;

import aha.graphql.domain.model.ImageResolution;

import lombok.Data;

@Data
public class ImageInfo {
    private ImageResolution resolution;
    private String location;
}
