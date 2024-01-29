package gov.toki.accountingapprestapi.core.service.abstracts;



public interface SuperAdminService extends EntityService, CreatableService<SuperAdminCreateRequestModel>, ReadableService<String>, UpdatableAtOnceService<SuperAdminUpdateRequestModel> {

    @Override
    <P> ServiceDataResponse<P> getOneByIdentifier(String username, Class<P> projection);

    <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection);
}
