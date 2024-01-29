package gov.toki.accountingapprestapi.core.service.objectmapping.manual.concretes;

@Component
@RequiredArgsConstructor
public class PageRequestMapper implements ManualMapper<PageRequestModel, PageRequest> {

    private final ManualMapper<SortRequestModel, Sort> sortMapper;

    @Override
    public PageRequest map(@ReturnIfNull PageRequestModel pageRequestModel) {
        return PageRequest.of(pageRequestModel.getPageNo(), pageRequestModel.getPageSize(), sortMapper.map(pageRequestModel.getSort()));
    }

}
