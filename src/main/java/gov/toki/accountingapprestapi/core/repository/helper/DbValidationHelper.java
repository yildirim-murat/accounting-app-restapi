package gov.toki.accountingapprestapi.core.repository.helper;


@Component
@Order(Ordered.LOWEST_PRECEDENCE)
@RequiredArgsConstructor
public class DbValidationHelper {

    private final Session session;

    public <T extends Entity> boolean existsByField(Class<T> entityClass, String fieldName, Object value) {
        return session
                       .createQuery("select 1 from %s where %s = :value".formatted(entityClass.getSimpleName(), fieldName))
                       .setParameter("value", value)
                       .uniqueResult() != null;
    }

}
