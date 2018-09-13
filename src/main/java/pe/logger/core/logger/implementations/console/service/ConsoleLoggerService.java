package pe.logger.core.logger.implementations.console.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import pe.logger.core.logger.dto.LoggerRequestDto;
import pe.logger.core.logger.dto.LoggerResponseDto;
import pe.logger.core.logger.service.LoggerService;

import java.util.logging.ConsoleHandler;

@Service
public class ConsoleLoggerService implements LoggerService {

    private static Logger logger;

    public ConsoleLoggerService() {
        logger = Logger.getLogger("MyLog");
    }

    @Override
    public LoggerResponseDto log(LoggerRequestDto loggerRequestDto) {
        LoggerResponseDto loggerResponseDto = new LoggerResponseDto();
        loggerResponseDto.setType(CONSOLE);
        logger.addHandler(new ConsoleHandler());
        logger.log(Level.INFO, loggerRequestDto.getMessage());
        loggerResponseDto.setSuccess(true);
        return loggerResponseDto;
    }

    @Override
    public boolean supports(LoggerRequestDto supportedClass) {
        return supportedClass.isToConsole();
    }
}
