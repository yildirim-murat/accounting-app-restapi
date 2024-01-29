package gov.toki.accountingapprestapi.core.service.model.request.pagerequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SortRequestModel implements RequestModel {

    @MaxCollectionSize(max = Validation.PageRequest.MAX_SIZE_ORDER_COUNT, message = MsgCode.VALIDATION_SORT_ORDERS_MAX_COLLECTION_SIZE)
    private List<@Valid OrderRequestModel> orders;

}
