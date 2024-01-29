package gov.toki.accountingapprestapi.core.repository.dataseeders.concretes;

@Component
@RequiredArgsConstructor
public class SuperAdminDataSeeder extends BaseDataSeeder<SuperAdmin, UUID> {

    @Override
    public void setData() {
        SuperAdmin user = new SuperAdmin();
        user.setUsername("smh01.2019@gmail.com");
        user.setPhoneNumber("+90-500-500-50-50");
        user.setBirthDate(LocalDate.now());
        user.setFirstName("Semih");
        user.setLastName("Kayan");
        user.setPassword("$2a$12$ed4t6xhT2/9kQ6rM1YZ5uuNCbsKP55O8PGZ94hTD0nojJbh/GYELa");
        user.setLanguage(Identifiable.getInstance(Language::new, 59));
        data.add(user);
    }

}
