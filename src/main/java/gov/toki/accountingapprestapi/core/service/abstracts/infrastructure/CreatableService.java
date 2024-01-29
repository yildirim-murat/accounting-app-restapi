package gov.toki.accountingapprestapi.core.service.abstracts.infrastructure;

public interface CreatableService<ModelType extends RequestModel> extends EntityService {

    ServiceDataResponse<Model> create(ModelType model);

}
