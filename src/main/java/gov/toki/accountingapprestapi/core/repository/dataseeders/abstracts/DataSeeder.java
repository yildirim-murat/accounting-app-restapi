package gov.toki.accountingapprestapi.core.repository.dataseeders.abstracts;

/**
 * Dependent to JPA Repository
 */
public interface DataSeeder<T extends Identifiable<ID>, ID> extends Ordered {

    /**
     * Order by getOrder() method and call seed() method for all seeders
     */
    static void seedAll(Collection<DataSeeder<?, ?>> dataSeeders) {
        dataSeeders.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(DataSeeder::getOrder))
                .forEach(DataSeeder::seed);
        for (DataSeeder<?, ?> seeder : dataSeeders) seeder.getData().clear();
    }

    default int getOrder() {
        return LOWEST_PRECEDENCE;
    }

    /**
     * @return JPA Repository which related to given entity type
     * @implSpec Be aware that the type T should have a proper JPA repository
     */
    JpaRepositoryAdapter<T, ID> getRepository();

    EntityManager getEntityManager();

    /**
     * @return The data to be seed
     */
    Collection<T> getData();

    void setData();

    default boolean seedCondition() {
        return !isSeeded() && getRepository().count() == 0L;
    }

    /**
     * @return If is seed() method called
     */
    boolean isSeeded();

    void setSeeded(boolean loaded);

    /**
     * Used to save the data from getData() method via the JPA repository returned from getRepository() method
     */
    @LogExecutionTime
    default void seed() {
        if (!seedCondition()) return;

        setData();
        for (T datum : getData()) datum.setId(null);
        Collection<T> data = getData();
        if (data == null) return;

        getRepository().saveAll(data);

        setSeeded(true);
    }

}
