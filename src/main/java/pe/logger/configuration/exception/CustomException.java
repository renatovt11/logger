package pe.logger.configuration.exception;

import lombok.Getter;

public class CustomException extends RuntimeException {

    @Getter
    private String errorCode;

    public CustomException(String errorCode) {
        this.errorCode = errorCode;
    }

    public CustomException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

}
