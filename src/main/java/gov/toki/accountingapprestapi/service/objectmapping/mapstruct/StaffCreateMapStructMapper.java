package gov.toki.accountingapprestapi.service.objectmapping.mapstruct;

@Setter(onMethod = @__(@Autowired))
@Mapper(componentModel = "spring")
public abstract class StaffCreateMapStructMapper implements MapStructMapper<StaffCreateRequestModel, Staff> {

    protected BCryptPasswordEncoder passwordEncoder;

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(source.getPassword()))")
    @Mapping(target = "language.id", source = "source.languageId")
    public abstract Staff map(StaffCreateRequestModel source);

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(source.getPassword()))")
    @Mapping(target = "language.id", source = "source.languageId")
    public abstract Staff mapInto(StaffCreateRequestModel source, @MappingTarget Staff destination);

    @Mapping(target = "password", expression = "java(null)")
    @Mapping(target = "languageId", source = "destination.language.id")
    public abstract StaffCreateRequestModel mapReverse(Staff destination);

}


