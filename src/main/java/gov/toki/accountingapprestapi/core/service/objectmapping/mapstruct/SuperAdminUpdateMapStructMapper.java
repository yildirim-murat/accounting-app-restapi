package gov.toki.accountingapprestapi.core.service.objectmapping.mapstruct;

@Mapper(componentModel = "spring", imports = MappingHelper.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class SuperAdminUpdateMapStructMapper implements MapStructMapper<SuperAdminUpdateRequestModel, SuperAdmin> {

    @Mapping(target = "language.id", source = "source.languageId")
    public abstract SuperAdmin map(SuperAdminUpdateRequestModel source);

    @Mapping(target = "language", expression = "java(MappingHelper.mapRefIgnoreNull(superAdmin.getLanguage(), Language::new, source.getLanguageId()))")
    public abstract SuperAdmin mapInto(SuperAdminUpdateRequestModel source, @MappingTarget SuperAdmin superAdmin);

    @Mapping(target = "languageId", source = "destination.language.id")
    public abstract SuperAdminUpdateRequestModel mapReverse(SuperAdmin destination);

}
