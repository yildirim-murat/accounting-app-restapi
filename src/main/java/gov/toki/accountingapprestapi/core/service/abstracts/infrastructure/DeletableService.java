package gov.toki.accountingapprestapi.core.service.abstracts.infrastructure;

public interface DeletableService<ID> extends EntityService {

    ServiceResponse delete(ID id);

}
