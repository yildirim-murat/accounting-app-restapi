package gov.toki.accountingapprestapi.service.objectmapping.mapstruct;

@Setter(onMethod = @__(@Autowired))
@Mapper(componentModel = "spring")
public abstract class CustomerCreateMapStructMapper implements MapStructMapper<CustomerCreateRequestModel, Customer> {

    protected BCryptPasswordEncoder passwordEncoder;

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(source.getPassword()))")
    @Mapping(target = "language.id", source = "source.languageId")
    public abstract Customer map(CustomerCreateRequestModel source);

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(source.getPassword()))")
    @Mapping(target = "language.id", source = "source.languageId")
    public abstract Customer mapInto(CustomerCreateRequestModel source, @MappingTarget Customer destination);

    @Mapping(target = "password", expression = "java(null)")
    @Mapping(target = "languageId", source = "destination.language.id")
    public abstract CustomerCreateRequestModel mapReverse(Customer destination);

}


