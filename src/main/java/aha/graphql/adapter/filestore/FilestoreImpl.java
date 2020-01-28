package aha.graphql.adapter.filestore;

import aha.graphql.domain.FileRepository;
import aha.graphql.domain.model.ImageStream;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Repository
public class FilestoreImpl implements FileRepository {

    @Override
    public Path storeImage(ImageStream imageStream) throws IOException {
        Path tempDirWithPrefix = Files.createTempDirectory(imageStream.getProductId().toString());
        Path tmpFile = tempDirWithPrefix.resolve(Path.of(imageStream.getName()));
        //Path tmpFile = Files.createTempFile(imageStream.getProductId().toString(), imageStream.getName());
        Files.write(tmpFile, imageStream.getBase64Stream().getBytes());
        return tmpFile;

    }


}
