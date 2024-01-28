package gov.toki.accountingapprestapi.core.domain.helper;

@Component
public class MessageHelper {

    @Getter
    private static MessageSource messageSource;

    @Autowired
    public synchronized void setMessageSource(MessageSource messageSource) {
        if (MessageHelper.messageSource == null)
            MessageHelper.messageSource = messageSource;
    }

}
