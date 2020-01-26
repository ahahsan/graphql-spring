package org.aha.graphql.adapter.filestore;

import org.aha.graphql.domain.FileRepository;
import org.aha.graphql.domain.model.ImageStream;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Repository
public class FilestoreImpl implements FileRepository {

    @Override
    public Path storeImage(ImageStream imageStream) throws IOException {
        Path tmpFile = Files.createTempFile(imageStream.getProductId().toString(), imageStream.getName());
        Files.write(tmpFile, imageStream.getBase64Stream().getBytes());
        return tmpFile;

    }


}
