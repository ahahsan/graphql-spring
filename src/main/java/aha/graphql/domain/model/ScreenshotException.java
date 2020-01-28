package aha.graphql.domain.model;

public class ScreenshotException extends RuntimeException {
    public ScreenshotException(final String message, Exception e){
        super(message, e);
    }
}
