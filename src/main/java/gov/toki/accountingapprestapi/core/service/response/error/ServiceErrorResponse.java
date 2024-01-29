package gov.toki.accountingapprestapi.core.service.response.error;


public class ServiceErrorResponse extends ServiceResponse {

    public ServiceErrorResponse(String messageCode, Object... args) {
        super(messageCode, args);
    }

    public ServiceErrorResponse(String messageCode) {
        this(messageCode, (Object[]) null);
    }

    public ServiceErrorResponse() {
        this(MsgCode.COMMON_ERROR, (Object[]) null);
    }

}
