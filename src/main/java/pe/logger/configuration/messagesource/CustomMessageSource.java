package pe.logger.configuration.messagesource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import java.util.Locale;

@Controller
public class CustomMessageSource {

    private final MessageSource messageSource;

    public CustomMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String messageCode) {
        return messageSource.getMessage(messageCode, new Object[]{}, Locale.ENGLISH);
    }

}
