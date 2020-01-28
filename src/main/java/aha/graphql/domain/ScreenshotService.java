package aha.graphql.domain;

import aha.graphql.adapter.graphql.model.ImageUpload;
import aha.graphql.domain.model.Screenshot;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ScreenshotService {
    Screenshot createScreenshot(ImageUpload upload);
    List<Screenshot> findByProductId(UUID productId);
}
