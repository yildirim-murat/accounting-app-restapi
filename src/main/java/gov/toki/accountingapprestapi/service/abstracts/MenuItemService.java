package gov.toki.accountingapprestapi.service.abstracts;

public interface MenuItemService extends EntityService, CreatableService<MenuItemCreateRequestModel>, ReadableService<UUID> {

    ServiceResponse updateName(UUID id, String name);

    ServiceResponse updateCalories(UUID id, Integer calories);

}
