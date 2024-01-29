package gov.toki.accountingapprestapi.core.service.objectmapping.manual.concretes;

@Component
public class AuthorityNameMapper implements CollectionMapper<GrantedAuthority, String> {

    @Override
    public String map(GrantedAuthority source) {
        return source.getAuthority();
    }

}
