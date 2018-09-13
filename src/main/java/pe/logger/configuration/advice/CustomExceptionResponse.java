package pe.logger.configuration.advice;

import lombok.Data;

@Data
public class CustomExceptionResponse {

    private String errorCode;
    private String message;

}
