package gov.toki.accountingapprestapi.core.service.helper;

@UtilityClass
public class EntityServiceHelper {

    private final EntityManager entityManager = BeanHelper.getBean(EntityManager.class);

    public <T extends Identifiable<ID>, ID> T saveAndRefresh(JpaRepositoryAdapter<T, ID> repository, T entity) {
        T saved = repository.saveAndFlush(entity);
        entityManager.refresh(saved);
        return saved;
    }

}
