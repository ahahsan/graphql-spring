package aha.graphql.domain;

import aha.graphql.domain.model.Image;
import aha.graphql.domain.model.Screenshot;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Repository
public interface ScreenshotRepository {
    Screenshot createScreenshot(String title, UUID productId, Image onex, Image twoX, Locale locale);
    List<Screenshot> findByProductId(UUID productId);
}
