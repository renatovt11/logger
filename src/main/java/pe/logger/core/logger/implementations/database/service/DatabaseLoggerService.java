package pe.logger.core.logger.implementations.database.service;

import org.springframework.stereotype.Service;
import pe.logger.core.logger.dao.repository.LoggerRepository;
import pe.logger.core.logger.dto.LoggerRequestDto;
import pe.logger.core.logger.dto.LoggerResponseDto;
import pe.logger.core.logger.mapper.LoggerMapper;
import pe.logger.core.logger.service.LoggerService;

@Service
public class DatabaseLoggerService implements LoggerService {

    private final LoggerRepository loggerRepository;
    private final LoggerMapper loggerMapper;

    public DatabaseLoggerService(LoggerRepository loggerRepository, LoggerMapper loggerMapper) {
        this.loggerRepository = loggerRepository;
        this.loggerMapper = loggerMapper;
    }

    @Override
    public LoggerResponseDto log(LoggerRequestDto loggerRequestDto) {
        LoggerResponseDto loggerResponseDto = new LoggerResponseDto();
        loggerResponseDto.setType(DATABASE);
        this.loggerRepository.save(this.loggerMapper.convert(loggerRequestDto));
        loggerResponseDto.setSuccess(true);
        return loggerResponseDto;
    }

    @Override
    public boolean supports(LoggerRequestDto supportedClass) {
        return supportedClass.isToDatabase();
    }

}
