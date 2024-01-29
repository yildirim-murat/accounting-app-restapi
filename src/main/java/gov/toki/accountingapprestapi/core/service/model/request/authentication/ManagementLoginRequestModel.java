package gov.toki.accountingapprestapi.core.service.model.request.authentication;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagementLoginRequestModel implements RequestModel {

    @NotEmpty(message = MsgCode.VALIDATION_LOGIN_MANAGEMENT_IDENTIFIER_NOT_NULL)
    private String identifier;

    @NotEmpty(message = MsgCode.VALIDATION_LOGIN_PASSWORD_NOT_NULL)
    private String password;

}
