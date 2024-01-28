package gov.toki.accountingapprestapi.core.repository.dataseeders.abstracts;

@Getter
@Setter
public abstract class BaseDataSeeder<T extends Identifiable<ID>, ID> implements DataSeeder<T, ID> {

    protected boolean seeded;

    @Setter(AccessLevel.NONE)
    protected Collection<T> data = new LinkedList<>();

    @Setter(onMethod = @__(@Autowired))
    protected JpaRepositoryAdapter<T, ID> repository;

    @Setter(onMethod = @__(@Autowired))
    protected EntityManager entityManager;

}
