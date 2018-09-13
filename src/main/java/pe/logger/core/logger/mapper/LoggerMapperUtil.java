package pe.logger.core.logger.mapper;

import pe.logger.common.constant.ErrorConstant;
import pe.logger.common.enums.LoggerType;
import pe.logger.configuration.exception.CustomException;

public class LoggerMapperUtil {

    public static String convertType(String type) {
        LoggerType loggerType = LoggerType.parseByType(type);
        if (loggerType == null) {
            throw new CustomException(ErrorConstant.NO_VALID_LOG_TYPE);
        }
        return loggerType.getCode();
    }

}
