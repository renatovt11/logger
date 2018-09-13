package pe.logger.configuration.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import pe.logger.configuration.exception.CustomException;
import pe.logger.configuration.messagesource.CustomMessageSource;

@RestControllerAdvice
public class ExceptionAdvice {

    private final CustomMessageSource customMessageSource;

    public ExceptionAdvice(CustomMessageSource customMessageSource) {
        this.customMessageSource = customMessageSource;
    }

    @ExceptionHandler(value = {CustomException.class})
    protected ResponseEntity<Object> handlerCulqiException(RuntimeException ex, WebRequest request) {
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse();
        customExceptionResponse.setErrorCode(((CustomException) ex).getErrorCode());
        customExceptionResponse.setMessage(this.customMessageSource.getMessage(((CustomException) ex).getErrorCode()));
        return new ResponseEntity<>(customExceptionResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
