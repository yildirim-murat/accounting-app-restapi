package gov.toki.accountingapprestapi.service.concretes;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuItemServiceImpl extends BaseReadableServiceImpl<MenuItem, UUID> implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final MapStructMapper<MenuItemCreateRequestModel, MenuItem> createRequestMapper;
    private final MapStructMapper<MenuItem, MenuItemResponse> menuItemResponseMapper;

    @Override
    public ServiceDataResponse<Model> create(MenuItemCreateRequestModel model) {
        MenuItem saved = EntityServiceHelper.saveAndRefresh(menuItemRepository, createRequestMapper.map(model));
        return new ServiceSuccessDataResponse<>(menuItemResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateName(UUID id, String name) {
        return ResponseHelper.getResponseBySuccess(menuItemRepository.updateName(id, name), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateCalories(UUID id, Integer calories) {
        return ResponseHelper.getResponseBySuccess(menuItemRepository.updateCalories(id, calories), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
