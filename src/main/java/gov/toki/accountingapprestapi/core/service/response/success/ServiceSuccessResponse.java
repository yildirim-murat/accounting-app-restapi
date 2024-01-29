package gov.toki.accountingapprestapi.core.service.response.success;


public class ServiceSuccessResponse extends ServiceResponse {

    public ServiceSuccessResponse(String messageCode, Object... args) {
        super(messageCode, args);
    }

    public ServiceSuccessResponse(String messageCode) {
        this(messageCode, (Object[]) null);
    }

    public ServiceSuccessResponse() {
        this(MsgCode.COMMON_SUCCESS, (Object[]) null);
    }

}
