package net.momirealms.biomeapi;

public class UnsupportedVersionException extends RuntimeException {

    public UnsupportedVersionException(String message) {
        super(message);
    }

    public UnsupportedVersionException(String message, Throwable cause) {
        super(message, cause);
    }
}
