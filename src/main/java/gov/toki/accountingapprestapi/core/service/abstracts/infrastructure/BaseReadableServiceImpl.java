package gov.toki.accountingapprestapi.core.service.abstracts.infrastructure;

@Setter(onMethod = @__(@Autowired))
@Validated
@Transactional
public abstract class BaseReadableServiceImpl<E extends Identifiable<ID>, ID> implements ReadableService<ID> {

    protected JpaRepositoryAdapter<E, ID> repository;
    protected Mapper<PageRequestModel, PageRequest> pageRequestMapper;

    @Override
    public <P> ServiceDataResponse<P> getOneByIdentifier(ID id, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(repository.findById(id, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getList(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(repository.findAllBy(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

}
