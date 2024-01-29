package gov.toki.accountingapprestapi.service.abstracts;

public interface CustomerTypeService extends EntityService, CreatableService<CustomerTypeCreateRequestModel>, ReadableService<Integer> {

    ServiceResponse updateName(Integer id, String name);

    ServiceResponse updateDesc(Integer id, String desc);
}
