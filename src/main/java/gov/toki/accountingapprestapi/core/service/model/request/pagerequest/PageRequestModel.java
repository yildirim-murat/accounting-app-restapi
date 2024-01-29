package gov.toki.accountingapprestapi.core.service.model.request.pagerequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestModel implements RequestModel {

    @Min(value = Validation.PageRequest.MIN_VAL_PAGE_NUMBER, message = MsgCode.VALIDATION_PAGE_REQUEST_PAGE_NO_MIN)
    private Integer pageNo = 0;

    @Min(value = Validation.PageRequest.MIN_VAL_PAGE_SIZE, message = MsgCode.VALIDATION_PAGE_REQUEST_PAGE_SIZE_MIN)
    @Max(value = Validation.PageRequest.MAX_VAL_PAGE_SIZE, message = MsgCode.VALIDATION_PAGE_REQUEST_PAGE_SIZE_MAX)
    private Integer pageSize = 10;

    @Valid
    private SortRequestModel sort;

}
