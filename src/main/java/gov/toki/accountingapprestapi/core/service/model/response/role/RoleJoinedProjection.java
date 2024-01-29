package gov.toki.accountingapprestapi.core.service.model.response.role;

public interface RoleJoinedProjection extends IdentifiableModel<Integer> {

    String getName();

    String getDescription();

    Collection<PrivilegeQuickProjection> getPrivileges();

}
