package gov.toki.accountingapprestapi.core.service.objectmapping.mapstruct;


@Mapper(componentModel = "spring", uses = {LanguageResponseMapStructMapper.class, RoleResponseMapStructMapper.class})
public abstract class SuperAdminResponseMapStructMapper implements MapStructMapper<SuperAdmin, SuperAdminResponse> {
}
