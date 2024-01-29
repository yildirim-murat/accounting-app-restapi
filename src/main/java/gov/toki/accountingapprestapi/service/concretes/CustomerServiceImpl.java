package gov.toki.accountingapprestapi.service.concretes;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final PageRequestMapper pageRequestMapper;
    private final MapStructMapper<CustomerCreateRequestModel, Customer> createRequestMapper;
    private final MapStructMapper<Customer, CustomerResponse> customerResponseMapper;

    @Override
    public String getPasswordByTckn(String tckn) {
        return customerRepository.findPasswordByTckn(tckn);
    }

    @Override
    public <P> ServiceDataResponse<P> getOneByIdentifier(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(customerRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public UserAuthProjection getCustomerForLoginByTckn(String tckn) {
        return customerRepository.findByUsernameForLogin(tckn).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public <P> ServiceResponse getList(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(customerRepository.findAllBy(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(customerRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(CustomerCreateRequestModel model) {
        Customer saved = EntityServiceHelper.saveAndRefresh(customerRepository, createRequestMapper.map(model));
        return new ServiceSuccessDataResponse<>(customerResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateType(UUID id, Integer customerTypeId) {
        return ResponseHelper.getResponseBySuccess(customerRepository.updateType(id, customerTypeId), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
