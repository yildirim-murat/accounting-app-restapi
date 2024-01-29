package gov.toki.accountingapprestapi.core.repository.abstracts;

@Repository
public interface RoleRepository extends JpaRepositoryAdapter<Role, Integer> {

    <P> Optional<P> findFirstByName(String name, Class<P> projection);

}
