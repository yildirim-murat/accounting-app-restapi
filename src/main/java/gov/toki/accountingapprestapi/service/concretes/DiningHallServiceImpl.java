package gov.toki.accountingapprestapi.service.concretes;

@Service
@Transactional
@RequiredArgsConstructor
public class DiningHallServiceImpl extends BaseReadableServiceImpl<DiningHall, Integer> implements DiningHallService {

    private final DiningHallRepository diningHallRepository;
    private final DiningHallResponseMapStructMapper diningHallResponseMapper;
    private final DiningHallCreateMapStructMapper diningHallCreateMapper;

    @Override
    public ServiceResponse getCount() {
        return new ServiceSuccessDataResponse<>(diningHallRepository.count(), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceResponse getTotalCapacity() {
        return new ServiceSuccessDataResponse<>(diningHallRepository.getTotalCapacity(), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getOneFullyJoinedId(Integer id, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(diningHallRepository.findFirstFullyJoinedById(id, projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getListFullyJoined(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(diningHallRepository.findFullyJoined(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(DiningHallCreateRequestModel model) {
        DiningHall saved = EntityServiceHelper.saveAndRefresh(diningHallRepository, diningHallCreateMapper.map(model));
        return new ServiceSuccessDataResponse<>(diningHallResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateName(Integer id, String name) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.updateName(id, name), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateDesc(Integer id, String desc) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.updateDesc(id, desc), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateAddress(Integer id, String address) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.updateAddress(id, address), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateLatitudeAndLongitude(Integer id, Double latitude, Double longitude) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.updateLatitudeAndLongitude(id, latitude, longitude), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateCapacity(Integer id, Integer capacity) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.updateCapacity(id, capacity), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse addMeal(Integer diningHallId, Integer mealId) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.addMeal(diningHallId, mealId), MsgCode.DINING_HALL_MEAL_ADD_SUCCESS);
    }

    @Override
    public ServiceResponse removeMeal(Integer diningHallId, Integer mealId) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.removeMeal(diningHallId, mealId), MsgCode.DINING_HALL_MEAL_REMOVE_SUCCESS);
    }

}
