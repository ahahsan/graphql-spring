package org.aha.graphql.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Image {
    private  final Long id;
    private  final ImageResolution resolution;
    private  final String location;
}
