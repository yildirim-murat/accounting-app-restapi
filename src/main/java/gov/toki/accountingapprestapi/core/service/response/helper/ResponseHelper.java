package gov.toki.accountingapprestapi.core.service.response.helper;


@UtilityClass
public class ResponseHelper {

    public static ServiceResponse getResponseBySuccess(boolean success, String successMsgCode) {
        if (success) return new ServiceSuccessResponse(successMsgCode);
        return new ServiceErrorResponse(MsgCode.COMMON_ERROR_INVALID);
    }

    public static ServiceResponse getResponseBySuccess(int numOfRowsToBeUpdated, String successMsgCode) {
        return getResponseBySuccess(numOfRowsToBeUpdated > 0, successMsgCode);
    }

}
