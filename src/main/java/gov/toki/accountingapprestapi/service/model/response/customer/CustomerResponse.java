package gov.toki.accountingapprestapi.service.model.response.customer;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse extends UserResponse {

    private String tckn;

    private String cardNo;

    private CustomerTypeResponse type;

    private List<CateringResponse> reservations;

}
