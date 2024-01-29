package gov.toki.accountingapprestapi.core.service.concretes;

@Service
@Transactional
@RequiredArgsConstructor
public class SuperAdminServiceImpl implements SuperAdminService {

    private final SuperAdminRepository superAdminRepository;
    private final UserRepository userRepository;
    private final MapStructMapper<SuperAdminCreateRequestModel, SuperAdmin> createRequestMapper;
    private final MapStructMapper<SuperAdminUpdateRequestModel, SuperAdmin> updateRequestMapper;
    private final MapStructMapper<SuperAdmin, SuperAdminResponse> superAdminResponseMapper;
    private final PageRequestMapper pageRequestMapper;

    @Override
    public <P> ServiceDataResponse<P> getOneByIdentifier(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(superAdminRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getList(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(superAdminRepository.findAllBy(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(superAdminRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(SuperAdminCreateRequestModel model) {
        SuperAdmin saved = EntityServiceHelper.saveAndRefresh(superAdminRepository, createRequestMapper.map(model));
        return new ServiceSuccessDataResponse<>(superAdminResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateChanges(SuperAdminUpdateRequestModel model) {
        SuperAdmin updated = updateRequestMapper.mapInto(model, superAdminRepository.getReferenceById(userRepository.findIdByUsername(model.getUsername())));
        return new ServiceSuccessDataResponse<>(superAdminResponseMapper.map(updated), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
