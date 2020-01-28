package aha.graphql.adapter.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import aha.graphql.adapter.graphql.mapper.ModelMapper;
import aha.graphql.adapter.graphql.model.ScreenshotInfo;
import aha.graphql.domain.ScreenshotService;
import aha.graphql.adapter.graphql.model.Screenshots;
import aha.graphql.domain.model.Screenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ScreenshotQuery implements GraphQLQueryResolver {

    @Autowired
    ScreenshotService screenshotService;

    public Screenshots allScreenshots(final String productId) {
        final List<Screenshot> screenshots =  screenshotService.findByProductId(UUID.fromString(productId));
        final List<ScreenshotInfo> localised = screenshots.stream().map(ModelMapper::mapToScreenshotInfo).collect(Collectors.toList());
        Screenshots screenshots1 = new Screenshots();
        screenshots1.setProductId(productId);
        screenshots1.setLocalised(localised);
        return screenshots1;
    }
}
