package pe.logger.core.logger.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.logger.common.constant.ErrorConstant;
import pe.logger.common.request.GlobalRequest;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoggerRequestDto extends GlobalRequest {

    private boolean toDatabase;
    private boolean toConsole;
    private boolean toFile;

    @NotNull(message = ErrorConstant.LOG_TYPE_REQUIRED)
    private String type;

    @NotNull(message = ErrorConstant.MESSAGE_REQUIRED)
    private String message;

}
