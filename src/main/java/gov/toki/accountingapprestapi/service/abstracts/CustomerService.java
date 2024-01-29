package gov.toki.accountingapprestapi.service.abstracts;

public interface CustomerService extends EntityService, CreatableService<CustomerCreateRequestModel>, ReadableService<String> {

    String getPasswordByTckn(String tckn);

    UserAuthProjection getCustomerForLoginByTckn(String tckn);

    <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection);

    ServiceResponse updateType(UUID id, Integer customerTypeId);

}
