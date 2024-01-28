package gov.toki.accountingapprestapi.service.abstracts;

public interface StaffService extends EntityService, CreatableService<StaffCreateRequestModel>, ReadableService<String> {

    ServiceResponse getCount();

    <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection);

}
