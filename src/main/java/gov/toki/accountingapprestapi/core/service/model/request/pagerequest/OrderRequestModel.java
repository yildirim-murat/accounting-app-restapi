package gov.toki.accountingapprestapi.core.service.model.request.pagerequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestModel implements RequestModel {

    @NotEmpty(message = MsgCode.VALIDATION_ORDER_PROPERTY_NOT_BLANK)
    private String property;

    private Sort.Direction direction = Sort.Direction.ASC;

    private Sort.NullHandling nullHandling = Sort.NullHandling.NULLS_LAST;

    private boolean ignoreCase = false;

}
