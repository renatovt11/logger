package pe.logger.core.logger.service;

import pe.logger.common.service.BaseAbstractService;
import pe.logger.core.logger.dto.LoggerRequestDto;
import pe.logger.core.logger.dto.LoggerResponseDto;

public interface LoggerService extends BaseAbstractService<LoggerRequestDto> {

    String DATABASE = "DATABASE";
    String CONSOLE = "CONSOLE";
    String FILE = "FILE";

    LoggerResponseDto log(LoggerRequestDto requestToEvaluate);

}
