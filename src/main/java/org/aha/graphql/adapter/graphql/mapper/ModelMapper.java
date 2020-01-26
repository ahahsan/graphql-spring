package org.aha.graphql.adapter.graphql.mapper;

import org.aha.graphql.adapter.graphql.model.ImageInfo;
import org.aha.graphql.adapter.graphql.model.ScreenshotInfo;
import org.aha.graphql.domain.model.Image;
import org.aha.graphql.domain.model.Screenshot;

public class ModelMapper {
    public static ScreenshotInfo mapToScreenshotInfo(final Screenshot screenshot){

        final ScreenshotInfo screenshotInfo =  new ScreenshotInfo();
        screenshotInfo.setProductId(screenshot.getProductId().toString());
        screenshotInfo.setTitle(screenshot.getTitle());
        screenshotInfo.setLocale(screenshot.getLocale().toLanguageTag());
        screenshotInfo.setImage1x(mapToImageInfo(screenshot.getImage1x()));
        screenshotInfo.setImage2x(mapToImageInfo(screenshot.getImage2x()));
        return screenshotInfo;
    }

    public static ImageInfo mapToImageInfo(final Image image){
        final ImageInfo imageInfo = new ImageInfo();
        imageInfo.setResolution(image.getResolution());
        imageInfo.setLocation(image.getLocation());
        return imageInfo;

    }
}
