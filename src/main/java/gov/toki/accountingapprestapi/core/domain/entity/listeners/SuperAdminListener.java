package gov.toki.accountingapprestapi.core.domain.entity.listeners;

public class SuperAdminListener {

    @PrePersist
    public void prePersist(SuperAdmin target) {
        ListenerHelper.addToRoles(target, RoleConst.Id.SUPER_ADMIN);
        ListenerHelper.addToRoles(target, RoleConst.Id.CUSTOMER);
        ListenerHelper.addToRoles(target, RoleConst.Id.STAFF);
    }

}
