package gov.toki.accountingapprestapi.service.concretes;

@Service
@Transactional
@RequiredArgsConstructor
public class MealServiceImpl extends BaseReadableServiceImpl<Meal, Integer> implements MealService {

    private final MealRepository mealRepository;
    private final MealResponseMapStructMapper mealResponseMapper;
    private final MealCreateMapStructMapper mealCreateMapper;

    @Override
    public ServiceResponse getCount() {
        return new ServiceSuccessDataResponse<>(mealRepository.count(), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(MealCreateRequestModel model) {
        Meal saved = EntityServiceHelper.saveAndRefresh(mealRepository, mealCreateMapper.map(model));
        return new ServiceSuccessDataResponse<>(mealResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateName(Integer id, String name) {
        return ResponseHelper.getResponseBySuccess(mealRepository.updateName(id, name), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateStart(Integer id, LocalTime start) {
        return ResponseHelper.getResponseBySuccess(mealRepository.updateStart(id, start), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateEnd(Integer id, LocalTime end) {
        return ResponseHelper.getResponseBySuccess(mealRepository.updateEnd(id, end), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
