package gov.toki.accountingapprestapi.service.concretes;

@Service
@Transactional
@RequiredArgsConstructor
public class CateringServiceImpl extends BaseReadableServiceImpl<Catering, UUID> implements CateringService {

    private final CateringRepository cateringRepository;
    private final MapStructMapper<CateringCreateRequestModel, Catering> createRequestMapper;
    private final MapStructMapper<Catering, CateringResponse> cateringResponseMapper;

    @Override
    public <P> ServiceResponse getOneFullyJoinedById(UUID id, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(cateringRepository.findFirstFullyJoinedById(id, projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getListFullyJoined(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(cateringRepository.findFullyJoined(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getListByDateBetween(PageRequestModel pageRequestModel, Class<P> projection, LocalDate lowerBound, LocalDate upperBound) {
        return new ServiceSuccessDataResponse<>(cateringRepository.findAllByDateBetween(lowerBound, upperBound, pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(CateringCreateRequestModel model) {
        Catering saved = EntityServiceHelper.saveAndRefresh(cateringRepository, createRequestMapper.map(model));
        return new ServiceSuccessDataResponse<>(cateringResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateMenuItems(CateringMenuUpdateRequestModel model) {
        Catering catering = cateringRepository.getReferenceById(model.getCateringId());
        boolean changed = model.getMenuItemIds().size() != catering.getMenuItems().size();
        for (MenuItem menuItem : catering.getMenuItems())
            if (!model.getMenuItemIds().contains(menuItem.getId())) {
                changed = true;
                break;
            }
        if (!changed) return ResponseHelper.getResponseBySuccess(true, MsgCode.COMMON_SUCCESS_UPDATED);
        catering.getMenuItems().clear();
        for (UUID menuItemId : model.getMenuItemIds())
            catering.getMenuItems().add(Identifiable.getInstance(MenuItem::new, menuItemId));
        return ResponseHelper.getResponseBySuccess(true, MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse addMenuItem(UUID cateringId, UUID menuItemId) {
        return ResponseHelper.getResponseBySuccess(cateringRepository.addMenuItem(cateringId, menuItemId), MsgCode.CATERING_MENU_ITEM_ADD_SUCCESS);
    }

    @Override
    public ServiceResponse removeMenuItem(UUID cateringId, UUID menuItemId) {
        return ResponseHelper.getResponseBySuccess(cateringRepository.removeMenuItem(cateringId, menuItemId), MsgCode.CATERING_MENU_ITEM_REMOVE_SUCCESS);
    }

}
