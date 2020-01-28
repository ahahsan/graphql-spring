package aha.graphql.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ImageStream {
    private String name;
    private UUID productId;
    private String base64Stream;
}
