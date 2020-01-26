package org.aha.graphql.domain;

import org.aha.graphql.domain.model.ImageStream;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Path;

@Repository
public interface FileRepository {
    Path storeImage(ImageStream strean) throws IOException;
}
