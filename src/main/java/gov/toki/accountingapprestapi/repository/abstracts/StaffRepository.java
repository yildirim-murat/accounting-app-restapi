package gov.toki.accountingapprestapi.repository.abstracts;


@Repository
public interface StaffRepository extends JpaRepositoryAdapter<Staff, UUID> {

    boolean existsByUsername(String username);

    @Query(value = """
                select u from Staff u
                left join fetch u.language l
                left join fetch u.roles r
                left join fetch r.privileges p
                where u.username = :username
            """)
    <P> Optional<P> findFullyJoinedByUsername(String username, Class<P> projection);

}
