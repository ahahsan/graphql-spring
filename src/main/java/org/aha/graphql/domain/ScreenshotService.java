package org.aha.graphql.domain;

import org.aha.graphql.adapter.graphql.model.ImageUpload;
import org.aha.graphql.domain.model.Screenshot;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ScreenshotService {
    Screenshot createScreenshot(ImageUpload upload);
    List<Screenshot> findByProductId(UUID productId);
}
