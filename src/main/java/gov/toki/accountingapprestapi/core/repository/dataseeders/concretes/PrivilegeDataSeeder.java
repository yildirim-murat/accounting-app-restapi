package gov.toki.accountingapprestapi.core.repository.dataseeders.concretes;

@Component
@RequiredArgsConstructor
public class PrivilegeDataSeeder extends BaseDataSeeder<Privilege, Integer> {

    @Override
    public int getOrder() {
        return 10;
    }

    @Override
    public void setData() {
    }

}
