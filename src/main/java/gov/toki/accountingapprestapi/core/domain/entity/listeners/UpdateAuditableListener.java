package gov.toki.accountingapprestapi.core.domain.entity.listeners;

public class UpdateAuditableListener {

    @PreUpdate
    public void preUpdate(UpdateAuditable target) {
        target.setModifiedAt(LocalDateTime.now());
        target.setModifier(SecurityStaticHelper.getUsername().orElse("[ANONYMOUS]"));
    }

}
