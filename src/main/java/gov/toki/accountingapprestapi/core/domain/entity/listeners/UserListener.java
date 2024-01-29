package gov.toki.accountingapprestapi.core.domain.entity.listeners;

public class UserListener {

    @PrePersist
    public void prePersist(User target) {
        ListenerHelper.addToRoles(target, RoleConst.Id.USER);
    }

    @PreRemove
    public void preRemove(User target) {
        for (Role role : target.getRoles())
            target.getRoles().remove(role);
    }

}
