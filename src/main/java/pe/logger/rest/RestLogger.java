package pe.logger.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.logger.common.controller.GlobalController;
import pe.logger.core.logger.LoggerManager;
import pe.logger.core.logger.dto.LoggerRequestDto;
import pe.logger.core.logger.dto.LoggerResponseDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("loggerRestService")
public class RestLogger extends GlobalController {

    private final LoggerManager loggerManager;

    public RestLogger(LoggerManager loggerManager) {
        this.loggerManager = loggerManager;
    }

    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public ResponseEntity<List<LoggerResponseDto>> log(@RequestBody @Valid LoggerRequestDto loggerRequestDto, BindingResult bindingResult) {
        super.evaluateValidation(bindingResult);
        return new ResponseEntity<>(this.loggerManager.log(loggerRequestDto), HttpStatus.OK);
    }

}
