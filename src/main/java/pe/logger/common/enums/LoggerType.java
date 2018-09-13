package pe.logger.common.enums;

import lombok.Getter;

@Getter
public enum LoggerType {

    MESSAGE("message", "Tipo info/mensaje", "1"),
    WARNING("warning", "Tipo advertencia", "2"),
    ERROR("error", "Tipo error", "3");

    private String type;
    private String description;
    private String code;

    LoggerType(String type, String description, String code) {
        this.type = type;
        this.description = description;
        this.code = code;
    }

    public static LoggerType parseByType(String type) {
        for (LoggerType loggerType : values()) {
            if(loggerType.type.equals(type)){
                return loggerType;
            }
        }
        return null;
    }

}
