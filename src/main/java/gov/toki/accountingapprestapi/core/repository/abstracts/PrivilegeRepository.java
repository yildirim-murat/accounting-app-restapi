package gov.toki.accountingapprestapi.core.repository.abstracts;

@Repository
public interface PrivilegeRepository extends JpaRepositoryAdapter<Privilege, Integer> {

    <P> Optional<P> findFirstByName(String name, Class<P> projection);

}
