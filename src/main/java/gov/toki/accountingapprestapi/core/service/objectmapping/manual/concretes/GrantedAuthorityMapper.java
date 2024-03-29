package gov.toki.accountingapprestapi.core.service.objectmapping.manual.concretes;

/**
 * @implSpec Source collection should have String getName() and Collection getPrivileges() methods.
 * And also, the Collection getPrivileges() method of source collection should have String getName() method.
 */
@Component
public class GrantedAuthorityMapper implements Mapper<Collection<?>, List<GrantedAuthority>> {

    private static final short APPROXIMATE_AUTHORITY_COUNT_PER_ROLE = 4;

    @Override
    public List<GrantedAuthority> map(Collection<?> source) {
        if (source == null) return new ArrayList<>();
        List<GrantedAuthority> destination = new ArrayList<>(source.size() * APPROXIMATE_AUTHORITY_COUNT_PER_ROLE);
        for (Object roleObj : source) {
            String roleName = ReflectionHelper.getFieldValueByGetter(roleObj, "getName", String.class).orElse(null);
            Iterable<?> privileges = ReflectionHelper.getFieldValueByGetter(roleObj, "getPrivileges", Iterable.class).orElse(new ArrayList<>(0));
            destination.add(new SimpleGrantedAuthority(roleName));
            for (Object privilege : privileges) {
                String privName = ReflectionHelper.getFieldValueByGetter(privilege, "getName", String.class).orElse(null);
                destination.add(new SimpleGrantedAuthority(privName));
            }
        }
        return destination;
    }

}
