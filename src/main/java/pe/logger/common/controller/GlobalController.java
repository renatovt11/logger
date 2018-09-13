package pe.logger.common.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.validation.BindingResult;
import pe.logger.configuration.exception.CustomException;

public abstract class GlobalController {

    public void evaluateValidation(BindingResult validation) {
        if (validation.hasErrors() && CollectionUtils.isNotEmpty(validation.getAllErrors())) {
            String message = validation.getAllErrors().get(0).getDefaultMessage();
            throw new CustomException(message);
        }
    }

}