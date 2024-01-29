package gov.toki.accountingapprestapi.core.repository.abstracts;

@Repository
public interface LanguageRepository extends JpaRepositoryAdapter<Language, Integer> {

    <P> Optional<P> findFirstByName(String englishName, Class<P> projection);

    <P> Optional<P> findFirstByLocalName(String localName, Class<P> projection);

    <P> Optional<P> findFirstByAlpha2(String alpha2, Class<P> projection);

    <P> Optional<P> findFirstByAlpha3T(String alpha3T, Class<P> projection);

    @Modifying
    @Query("update Language l set l.name = :name where l.id = :id")
    int updateName(@Param("id") Integer id, @Param("name") String name);

    @Modifying
    @Query("update Language l set l.localName = :localName where l.id = :id")
    int updateLocalName(@Param("id") Integer id, @Param("localName") String localName);

    @Modifying
    @Query("update Language l set l.alpha2 = :alpha2 where l.id = :id")
    int updateAlpha2(@Param("id") Integer id, @Param("alpha2") String alpha2);

    @Modifying
    @Query("update Language l set l.alpha3T = :alpha3T where l.id = :id")
    int updateAlpha3T(@Param("id") Integer id, @Param("alpha3T") String alpha3T);

    @Modifying
    @Query("update Language l set l.unlisted = :unlisted where l.id = :id")
    int updateUnlisted(@Param("id") Integer id, @Param("unlisted") Boolean unlisted);

    @Modifying
    @Query("update Language l set l.supported = :supported where l.id = :id")
    int updateSupported(@Param("id") Integer id, @Param("supported") Boolean supported);

}
