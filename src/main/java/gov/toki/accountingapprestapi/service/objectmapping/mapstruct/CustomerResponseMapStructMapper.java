package gov.toki.accountingapprestapi.service.objectmapping.mapstruct;

@Mapper(
        componentModel = "spring",
        uses = {
                LanguageResponseMapStructMapper.class,
                RoleResponseMapStructMapper.class,
                CustomerTypeResponseMapStructMapper.class,
                CateringResponseMapStructMapper.class
        })
public abstract class CustomerResponseMapStructMapper implements MapStructMapper<Customer, CustomerResponse> {
}
