package org.aha.graphql.adapter.datastore;

import org.aha.graphql.adapter.datastore.jpa.ScreenshotJpa;
import org.aha.graphql.adapter.datastore.mapper.EntityMapper;
import org.aha.graphql.adapter.datastore.model.ScreenshotEntity;
import org.aha.graphql.domain.ScreenshotRepository;
import org.aha.graphql.domain.model.Image;
import org.aha.graphql.domain.model.Screenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class DatastoreRepository implements ScreenshotRepository {

    @Autowired
    ScreenshotJpa screenshotJpa;

    @Override
    @Transactional
    public Screenshot createScreenshot(final String title, final UUID productId, Image onex, Image twoX, Locale locale) {
        ScreenshotEntity entity = new ScreenshotEntity();
        entity.setProductId(productId);
        entity.setTitle(title);
        entity.setLocale(locale.toLanguageTag());
        entity.setImageIx(EntityMapper.mapToImageEntity(onex));
        entity.setImage2x(EntityMapper.mapToImageEntity(twoX));
        screenshotJpa.save(entity);
        return EntityMapper.mapToScreenshot(entity);
    }

    @Override
    @Transactional
    public List<Screenshot> findByProductId(final UUID productId) {
        List<ScreenshotEntity> screenshots = screenshotJpa.findByProductId(productId);
        return screenshots.stream().map(EntityMapper::mapToScreenshot).collect(Collectors.toList());

    }
}