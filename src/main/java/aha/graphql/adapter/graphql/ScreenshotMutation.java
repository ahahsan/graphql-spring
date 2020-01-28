package aha.graphql.adapter.graphql;

import aha.graphql.domain.model.Screenshot;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import aha.graphql.adapter.graphql.mapper.ModelMapper;
import aha.graphql.adapter.graphql.model.ImageUpload;
import aha.graphql.adapter.graphql.model.ScreenshotInfo;
import aha.graphql.domain.ScreenshotService;

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
