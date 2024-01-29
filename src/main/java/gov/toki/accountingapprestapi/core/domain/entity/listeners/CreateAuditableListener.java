package gov.toki.accountingapprestapi.core.domain.entity.listeners;

public class CreateAuditableListener {

    @PrePersist
    public void prePersist(CreateAuditable target) {
        target.setCreatedAt(LocalDateTime.now());
        target.setCreator(SecurityStaticHelper.getUsername().orElse("[ANONYMOUS]"));
    }

}
