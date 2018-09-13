package pe.logger.core.logger.implementations.file.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.logger.core.logger.dto.LoggerRequestDto;
import pe.logger.core.logger.dto.LoggerResponseDto;
import pe.logger.core.logger.service.LoggerService;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Slf4j
@Service
public class FileLoggerService implements LoggerService {

    @Value("${log.file.folder}")
    private String logFileFolder;
    private static final String logFileName = "/logFile.txt";
    private static Logger logger;

    public FileLoggerService() {
        logger = Logger.getLogger("MyLog");
    }

    @Override
    public LoggerResponseDto log(LoggerRequestDto loggerRequestDto) {
        LoggerResponseDto loggerResponseDto = new LoggerResponseDto();
        loggerResponseDto.setType(FILE);
        File logFile = new File(this.logFileFolder + logFileName);
        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            FileHandler fileHandler = new FileHandler(this.logFileFolder + logFileName);
            logger.addHandler(fileHandler);
            logger.log(Level.INFO, loggerRequestDto.getMessage());
            loggerResponseDto.setSuccess(true);
        } catch (IOException e) {
            log.error("Ocurrió un error al crear el archivo: ", e);
        }
        return loggerResponseDto;
    }

    @Override
    public boolean supports(LoggerRequestDto supportedClass) {
        return supportedClass.isToFile();
    }

}
