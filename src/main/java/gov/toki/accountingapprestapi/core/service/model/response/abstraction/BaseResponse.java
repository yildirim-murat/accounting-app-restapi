package gov.toki.accountingapprestapi.core.service.model.response.abstraction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseResponse<ID> extends AuditedResponse {

    private ID id;

}
