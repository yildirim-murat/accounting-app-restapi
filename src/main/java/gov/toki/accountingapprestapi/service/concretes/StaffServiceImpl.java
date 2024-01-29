package gov.toki.accountingapprestapi.service.concretes;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final PageRequestMapper pageRequestMapper;
    private final MapStructMapper<StaffCreateRequestModel, Staff> createRequestMapper;
    private final MapStructMapper<Staff, StaffResponse> staffResponseMapper;

    @Override
    public ServiceResponse getCount() {
        return new ServiceSuccessDataResponse<>(staffRepository.count(), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceDataResponse<P> getOneByIdentifier(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(staffRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getList(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(staffRepository.findAllBy(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(staffRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(StaffCreateRequestModel model) {
        Staff saved = EntityServiceHelper.saveAndRefresh(staffRepository, createRequestMapper.map(model));
        return new ServiceSuccessDataResponse<>(staffResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

}
