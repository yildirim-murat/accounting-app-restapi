package gov.toki.accountingapprestapi.repository.abstracts;

@Repository
public interface CustomerTypeRepository extends JpaRepositoryAdapter<CustomerType, Integer> {

    @Modifying
    @Query("update CustomerType ct set ct.name = :name where ct.id = :id")
    int updateName(Integer id, String name);

    @Modifying
    @Query("update CustomerType ct set ct.description = :desc where ct.id = :id")
    int updateDesc(Integer id, String desc);

}
