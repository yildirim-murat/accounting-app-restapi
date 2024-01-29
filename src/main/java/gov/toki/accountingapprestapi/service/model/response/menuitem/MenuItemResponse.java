package gov.toki.accountingapprestapi.service.model.response.menuitem;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemResponse extends AuditedResponse {

    private UUID id;

    private String name;

    private Integer calories;

}
