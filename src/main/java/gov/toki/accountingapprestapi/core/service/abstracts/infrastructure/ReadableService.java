package gov.toki.accountingapprestapi.core.service.abstracts.infrastructure;

public interface ReadableService<Prop> extends EntityService {

    <P> ServiceDataResponse<P> getOneByIdentifier(Prop prop, Class<P> projection);

    <P> ServiceResponse getList(PageRequestModel pageRequestModel, Class<P> projection);

}
