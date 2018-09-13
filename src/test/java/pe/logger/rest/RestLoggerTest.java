package pe.logger.rest;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.logger.core.logger.LoggerManager;
import pe.logger.core.logger.dao.repository.LoggerRepository;
import pe.logger.core.logger.dto.LoggerRequestDto;
import pe.logger.core.logger.dto.LoggerResponseDto;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestLoggerTest {

    @Autowired
    private LoggerManager loggerManager;

    @Test
    public void log() {
        LoggerRequestDto loggerRequestDto = new LoggerRequestDto();
        loggerRequestDto.setToDatabase(true);
        loggerRequestDto.setToConsole(true);
        loggerRequestDto.setToFile(true);
        loggerRequestDto.setType("error");
        loggerRequestDto.setMessage("Este es un mensaje de pruebaaaaa.");
        List<LoggerResponseDto> loggerResponseDtos = this.loggerManager.log(loggerRequestDto);
        Assert.assertTrue(CollectionUtils.isNotEmpty(loggerResponseDtos));
    }

}