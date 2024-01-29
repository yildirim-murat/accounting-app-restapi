package gov.toki.accountingapprestapi.core.repository.dataseeders.concretes;

@Component
@RequiredArgsConstructor
public class RoleDataSeeder extends BaseDataSeeder<Role, Integer> {

    @Override
    public int getOrder() {
        return 20;
    }

    @Override
    public void setData() {
        data.addAll(RoleConst.roles().stream().toList());
    }

}
