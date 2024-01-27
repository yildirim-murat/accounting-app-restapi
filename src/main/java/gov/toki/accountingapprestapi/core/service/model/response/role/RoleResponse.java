package gov.toki.accountingapprestapi.core.service.model.response.role;

import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.core.service.model.response.privilege.PrivilegeResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

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
