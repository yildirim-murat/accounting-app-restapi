package gov.toki.accountingapprestapi.core.service.model.response.privilege;

import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;

public interface PrivilegeQuickProjection extends IdentifiableModel<Integer> {

    String getName();

    String getDescription();

}
