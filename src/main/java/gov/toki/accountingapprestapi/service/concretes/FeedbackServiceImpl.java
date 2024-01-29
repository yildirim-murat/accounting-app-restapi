package gov.toki.accountingapprestapi.service.concretes;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackServiceImpl extends BaseReadableServiceImpl<Feedback, UUID> implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final MapStructMapper<FeedbackCreateRequestModel, Feedback> createRequestMapper;
    private final MapStructMapper<Feedback, FeedbackResponse> responseMapper;

    @Override
    public <P> ServiceResponse getListByReviewed(Boolean reviewed, PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(feedbackRepository.findByReviewed(reviewed, pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getListByTopicContains(String containing, PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(feedbackRepository.findByTopicContainingIgnoreCase(containing, pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getListByContentContains(String containing, PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(feedbackRepository.findByContentContainingIgnoreCase(containing, pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(FeedbackCreateRequestModel model) {
        Feedback saved = EntityServiceHelper.saveAndRefresh(feedbackRepository, createRequestMapper.map(model));
        return new ServiceSuccessDataResponse<>(responseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateReviewed(UUID id, Boolean reviewed) {
        return ResponseHelper.getResponseBySuccess(feedbackRepository.updateReviewed(id, reviewed), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
