package gov.toki.accountingapprestapi.core.repository.dataseeders;

@Slf4j
@Component
@RequiredArgsConstructor
public class AllDataSeedersInitiator {

    private final Collection<DataSeeder<?, ?>> dataSeeders;

    @LogExecutionTime
    @EventListener(classes = ContextRefreshedEvent.class)
    @Transactional
    public void initiate() {
        DataSeeder.seedAll(dataSeeders);
    }

}
