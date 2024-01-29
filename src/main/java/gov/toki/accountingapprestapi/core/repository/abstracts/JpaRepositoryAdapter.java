package gov.toki.accountingapprestapi.core.repository.abstracts;

@NoRepositoryBean
public interface JpaRepositoryAdapter<T extends Identifiable<ID>, ID> extends JpaRepository<T, ID> {

    <P> Optional<P> findById(ID id, Class<P> projection);

    <P> Page<P> findAllBy(Pageable pageable, Class<P> projection);

}
