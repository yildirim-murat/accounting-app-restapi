package gov.toki.accountingapprestapi.core.domain.helper;

@UtilityClass
public class SecurityStaticHelper {

    private static final AuthorityNameMapper authorityNameMapper = BeanHelper.getBean(AuthorityNameMapper.class);

    public static Optional<Authentication> getAuthentication() {
        return Optional.ofNullable(SecurityContextHolder.getContext()).map(SecurityContext::getAuthentication);
    }

    public static Optional<Object> getPrincipal() {
        return getAuthentication().map(Authentication::getPrincipal);
    }

    public static Optional<String> getUsername() {
        return ReflectionHelper.getFieldValueByGetter(getPrincipal().orElse(null), "getUsername", String.class);
    }

    public static List<String> getAuthorities() {
        Optional<Authentication> authentication = SecurityStaticHelper.getAuthentication();
        if (authentication.isEmpty()) return Collections.emptyList();
        return authorityNameMapper.mapCollection(authentication.get().getAuthorities());
    }

}
