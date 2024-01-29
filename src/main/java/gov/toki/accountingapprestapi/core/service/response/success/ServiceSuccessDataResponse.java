package gov.toki.accountingapprestapi.core.service.response.success;

public class ServiceSuccessDataResponse<T> extends ServiceDataResponse<T> {

    public ServiceSuccessDataResponse(T data, String messageCode, Object... args) {
        super(data, messageCode, args);
    }

    public ServiceSuccessDataResponse(T data, String messageCode) {
        this(data, messageCode, (Object[]) null);
    }

    public ServiceSuccessDataResponse(T data) {
        this(data, MsgCode.COMMON_SUCCESS, (Object[]) null);
    }

}
