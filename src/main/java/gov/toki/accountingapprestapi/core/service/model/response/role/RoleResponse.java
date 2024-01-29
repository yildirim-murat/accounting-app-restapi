package gov.toki.accountingapprestapi.core.service.model.response.role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse implements Model {

    private Integer id;

    private String name;

    private String description;

    private Collection<PrivilegeResponse> privileges;

}
