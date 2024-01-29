package gov.toki.accountingapprestapi.service.objectmapping.mapstruct;

@Mapper(componentModel = "spring", uses = {LanguageResponseMapStructMapper.class, RoleResponseMapStructMapper.class})
public abstract class StaffResponseMapStructMapper implements MapStructMapper<Staff, StaffResponse> {
}
