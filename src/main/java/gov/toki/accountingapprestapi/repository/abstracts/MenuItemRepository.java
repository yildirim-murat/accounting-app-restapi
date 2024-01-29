package gov.toki.accountingapprestapi.repository.abstracts;

@Repository
public interface MenuItemRepository extends JpaRepositoryAdapter<MenuItem, UUID> {

    @Modifying
    @Query("update MenuItem m set m.name = :name where m.id = :id")
    int updateName(UUID id, String name);

    @Modifying
    @Query("update MenuItem m set m.calories = :calories where m.id = :id")
    int updateCalories(UUID id, Integer calories);

}
