package gov.toki.accountingapprestapi.core.api.config;

@ControllerAdvice
public class RequestConfig {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
