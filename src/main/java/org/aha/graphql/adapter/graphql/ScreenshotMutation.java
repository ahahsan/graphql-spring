package org.aha.graphql.adapter.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.aha.graphql.adapter.graphql.mapper.ModelMapper;
import org.aha.graphql.adapter.graphql.model.ImageUpload;
import org.aha.graphql.adapter.graphql.model.ScreenshotInfo;
import org.aha.graphql.domain.ScreenshotService;
import org.aha.graphql.domain.model.Screenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScreenshotMutation implements GraphQLMutationResolver {

    @Autowired
    ScreenshotService screenshotService;

    public ScreenshotInfo createScreenshot(final ImageUpload upload) {
        final Screenshot screenshot =  screenshotService.createScreenshot(upload);
        return ModelMapper.mapToScreenshotInfo(screenshot);
    }
}
