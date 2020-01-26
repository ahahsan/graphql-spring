package org.aha.graphql.adapter.graphql.model;

import lombok.Data;
import org.aha.graphql.domain.model.ImageResolution;

@Data
public class ImageInfo {
    private ImageResolution resolution;
    private String location;
}
