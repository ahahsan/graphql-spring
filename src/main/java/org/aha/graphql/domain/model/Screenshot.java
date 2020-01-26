package org.aha.graphql.domain.model;

import lombok.Data;

import java.util.Locale;
import java.util.UUID;

@Data
public class Screenshot {
    private String title;
    private UUID productId;
    private Locale locale;
    private Image image1x;
    private Image image2x;
}
