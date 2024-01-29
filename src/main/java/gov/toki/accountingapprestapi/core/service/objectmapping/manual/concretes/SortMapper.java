package gov.toki.accountingapprestapi.core.service.objectmapping.manual.concretes;

@Component
@RequiredArgsConstructor
public class SortMapper implements ManualMapper<SortRequestModel, Sort> {

    private final ManualMapper<OrderRequestModel, Sort.Order> orderMapper;

    @Override
    public Sort map(SortRequestModel sortModel) {
        return sortModel == null || sortModel.getOrders().isEmpty() ?
                Sort.unsorted() :
                Sort.by(orderMapper.mapCollection(sortModel.getOrders()));
    }

}
