package gov.toki.accountingapprestapi.service.model.request.customertype;

@Getter
@Setter
public class CustomerTypeCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_CUSTOMER_TYPE_NAME_NOT_NULL)
    @Size(min = Validation.CustomerType.MIN_LEN_NAME, max = Validation.CustomerType.MAX_LEN_NAME, message = MsgCode.VALIDATION_CUSTOMER_TYPE_NAME_SIZE)
    private String name;

    @NotNull(message = MsgCode.VALIDATION_CUSTOMER_TYPE_DESCRIPTION_NOT_NULL)
    @Size(min = Validation.CustomerType.MIN_LEN_DESC, max = Validation.CustomerType.MAX_LEN_DESC, message = MsgCode.VALIDATION_CUSTOMER_TYPE_DESCRIPTION_SIZE)
    private String description;

}