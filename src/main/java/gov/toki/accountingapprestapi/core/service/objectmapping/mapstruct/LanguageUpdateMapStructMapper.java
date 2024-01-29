package gov.toki.accountingapprestapi.core.service.objectmapping.mapstruct;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class LanguageUpdateMapStructMapper implements MapStructMapper<LanguageUpdateRequestModel, Language> {
}
