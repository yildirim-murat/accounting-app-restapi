package gov.toki.accountingapprestapi.core.domain.entity.listeners;

public class LanguageListener {

    @PrePersist
    public void prePersist(Language target) {
        target.setAlpha2(target.getAlpha2().toUpperCase());
        target.setAlpha3T(target.getAlpha3T().toUpperCase());
        target.setSupported(false);
    }

}
