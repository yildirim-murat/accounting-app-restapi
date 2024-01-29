package gov.toki.accountingapprestapi.core.service.abstracts;

public interface LanguageService extends EntityService, CreatableService<LanguageCreateRequestModel>, ReadableService<Integer>, UpdatableAtOnceService<LanguageUpdateRequestModel> {
    <P> ServiceResponse getByAlpha2(String alpha2, Class<P> projection);

    ServiceResponse updateName(Integer id, String name);

    ServiceResponse updateLocalName(Integer id, String localName);

    ServiceResponse updateAlpha2(Integer id, String alpha2);

    ServiceResponse updateAlpha3T(Integer id, String alpha3T);

    ServiceResponse updateUnlisted(Integer id, Boolean unlisted);

    ServiceResponse updateSupported(Integer id, Boolean unlisted);
}
