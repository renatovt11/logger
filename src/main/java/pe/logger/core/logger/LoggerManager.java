package pe.logger.core.logger;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pe.logger.common.constant.ErrorConstant;
import pe.logger.common.enums.LoggerType;
import pe.logger.common.manager.BaseAbstractServicesManager;
import pe.logger.configuration.exception.CustomException;
import pe.logger.core.logger.dto.LoggerRequestDto;
import pe.logger.core.logger.dto.LoggerResponseDto;
import pe.logger.core.logger.service.LoggerService;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class LoggerManager extends BaseAbstractServicesManager<LoggerService> {

    private final List<LoggerService> loggerServices;

    public LoggerManager(List<LoggerService> loggerServices) {
        this.loggerServices = loggerServices;
    }

    public List<LoggerResponseDto> log(LoggerRequestDto loggerRequestDto) {
        this.before(loggerRequestDto);
        List<LoggerResponseDto> loggerResponseDtos = new ArrayList<>();
        for (LoggerService loggerService : super.getSupportedServices(loggerRequestDto)) {
            loggerResponseDtos.add(loggerService.log(loggerRequestDto));
        }
        return loggerResponseDtos;
    }

    private void before(LoggerRequestDto loggerRequestDto) {
        LoggerType loggerType = LoggerType.parseByType(loggerRequestDto.getType());
        if(!loggerRequestDto.isToFile() && !loggerRequestDto.isToConsole() && !loggerRequestDto.isToDatabase()){
            throw new CustomException(ErrorConstant.NO_DESTINATION_SPECIFIED);
        }
        if(loggerType == null){
            throw new CustomException(ErrorConstant.NO_VALID_LOG_TYPE);
        }
        loggerRequestDto.setMessage(loggerType.getType() + " " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + loggerRequestDto.getMessage());
    }

    @Override
    protected List<LoggerService> getServiceList() {
        return this.loggerServices;
    }

}
