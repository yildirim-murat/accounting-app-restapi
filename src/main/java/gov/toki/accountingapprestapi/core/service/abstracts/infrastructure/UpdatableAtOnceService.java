package gov.toki.accountingapprestapi.core.service.abstracts.infrastructure;

public interface UpdatableAtOnceService<ModelType extends RequestModel> extends EntityService {

    ServiceResponse updateChanges(ModelType model);

}
