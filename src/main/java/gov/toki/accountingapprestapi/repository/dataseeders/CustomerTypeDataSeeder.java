package gov.toki.accountingapprestapi.repository.dataseeders;

@Component
public class CustomerTypeDataSeeder extends BaseDataSeeder<CustomerType, Integer> {

    @Override
    public int getOrder() {
        return 10;
    }

    @Override
    public void setData() {
        data.add(new CustomerType(null, "DEFAULT", "Waiting for type assignment"));
        data.add(new CustomerType(null, "STUDENT", "Student"));
        data.add(new CustomerType(null, "PERSONNEL", "Personnel"));
    }

}