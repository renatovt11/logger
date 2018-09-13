package pe.logger.core.logger.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import pe.logger.core.logger.dao.entity.LoggerEntity;
import pe.logger.core.logger.dto.LoggerRequestDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, imports = LoggerMapperUtil.class)
public interface LoggerMapper {

    @Mappings({
            @Mapping(expression = "java(LoggerMapperUtil.convertType(loggerRequestDto.getType()))", target = "type")
    })
    LoggerEntity convert(LoggerRequestDto loggerRequestDto);

}