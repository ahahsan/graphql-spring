package org.aha.graphql.adapter.datastore.mapper;

import org.aha.graphql.adapter.datastore.model.ImageEntity;
import org.aha.graphql.adapter.datastore.model.ScreenshotEntity;
import org.aha.graphql.domain.model.Image;
import org.aha.graphql.domain.model.ImageResolution;
import org.aha.graphql.domain.model.Screenshot;

import java.util.Locale;

public class EntityMapper {

    public static ImageEntity mapToImageEntity(final Image image) {
        ImageEntity entity = new ImageEntity();
        entity.setResolution(image.getResolution().toString());
        entity.setLocation(image.getLocation());
        return entity;
    }

    public static Image mapToImage(final ImageEntity entity) {
        return new Image(entity.getId(), ImageResolution.valueOf(entity.getResolution()), entity.getLocation());
    }

    public static Screenshot mapToScreenshot(final ScreenshotEntity entity) {
        Screenshot screenshot = new Screenshot();
        screenshot.setProductId(entity.getProductId());
        screenshot.setLocale(Locale.forLanguageTag(entity.getLocale()));
        screenshot.setTitle(entity.getTitle());
        screenshot.setImage1x(mapToImage(entity.getImageIx()));
        screenshot.setImage2x(mapToImage(entity.getImage2x()));
        return screenshot;
    }
}
