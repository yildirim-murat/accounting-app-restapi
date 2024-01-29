package gov.toki.accountingapprestapi.core.repository.abstracts;

@Repository
public interface SuperAdminRepository extends JpaRepositoryAdapter<SuperAdmin, UUID> {

    boolean existsByUsername(String username);

    @Query(value = """
                select s from SuperAdmin s
                left join fetch s.language l
                left join fetch s.roles r
                left join fetch r.privileges p
                where s.username = :username
            """)
    <P> Optional<P> findFullyJoinedByUsername(String username, Class<P> projection);

}
