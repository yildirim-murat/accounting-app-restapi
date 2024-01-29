package gov.toki.accountingapprestapi.core.service.objectmapping.mapstruct;

@Mapper(componentModel = "spring", uses = PrivilegeResponseMapStructMapper.class)
public abstract class RoleResponseMapStructMapper implements MapStructMapper<Role, RoleResponse> {
}
