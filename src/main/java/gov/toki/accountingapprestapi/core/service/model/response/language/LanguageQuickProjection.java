package gov.toki.accountingapprestapi.core.service.model.response.language;

public interface LanguageQuickProjection extends IdentifiableModel<Integer> {

    String getName();

    String getLocalName();

    String getAlpha2();

    String getAlpha3T();

    Boolean getUnlisted();

    Boolean getSupported();

}
