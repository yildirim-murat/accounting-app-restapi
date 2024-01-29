package gov.toki.accountingapprestapi.service.concretes;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerTypeServiceImpl extends BaseReadableServiceImpl<CustomerType, Integer> implements CustomerTypeService {

    private final CustomerTypeRepository customerTypeRepository;
    private final CustomerTypeResponseMapStructMapper customerTypeResponseMapper;
    private final CustomerTypeCreateMapStructMapper customerTypeCreateMapper;

    @Override
    public ServiceDataResponse<Model> create(CustomerTypeCreateRequestModel model) {
        CustomerType saved = EntityServiceHelper.saveAndRefresh(customerTypeRepository, customerTypeCreateMapper.map(model));
        return new ServiceSuccessDataResponse<>(customerTypeResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateName(Integer id, String name) {
        return ResponseHelper.getResponseBySuccess(customerTypeRepository.updateName(id, name), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateDesc(Integer id, String desc) {
        return ResponseHelper.getResponseBySuccess(customerTypeRepository.updateDesc(id, desc), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
