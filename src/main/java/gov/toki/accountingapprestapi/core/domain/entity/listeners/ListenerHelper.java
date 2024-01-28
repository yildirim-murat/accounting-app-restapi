package gov.toki.accountingapprestapi.core.domain.entity.listeners;

@UtilityClass
public class ListenerHelper {

    public void addToRoles(User user, Integer roleId) {
        Role role = RoleConst.getInstanceById(roleId);
        if (user.getRoles() == null) {
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
        } else user.getRoles().add(role);
    }

}
