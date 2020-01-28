package aha.graphql.domain;

import aha.graphql.adapter.graphql.model.ImageUpload;
import aha.graphql.domain.model.Image;
import aha.graphql.domain.model.ImageResolution;
import aha.graphql.domain.model.ImageStream;
import aha.graphql.domain.model.Screenshot;
import aha.graphql.domain.model.ScreenshotException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class ScreenshotServiceImpl implements ScreenshotService {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    ScreenshotRepository screenshotRepository;

    @Override
    public Screenshot createScreenshot(final ImageUpload upload) {
        try {
            final Path imageLoc1 = storeImage(upload);
            Image oneX = new Image(null, ImageResolution.ONEX, imageLoc1.toString());
            Image twoX = new Image(null, ImageResolution.TWOX, imageLoc1.toString());

            final Screenshot screenshot =
                    screenshotRepository.createScreenshot(upload.getTitle(), UUID.fromString(upload.getProductId()), oneX, twoX, Locale.forLanguageTag(upload.getLocale()));
            return screenshot;
        } catch (IOException e) {
            throw new ScreenshotException("failed to create screenshot", e);
        }
    }

    @Override
    public List<Screenshot> findByProductId(final UUID productId) {
        return screenshotRepository.findByProductId(productId);
    }

    private Path storeImage(final ImageUpload upload) throws IOException {
        return fileRepository.storeImage(new ImageStream(upload.getName(), UUID.fromString(upload.getProductId()), upload.getPayload()));
    }
}
