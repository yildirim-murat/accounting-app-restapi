package gov.toki.accountingapprestapi.core.service.model.request.user;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordUpdateRequest {

    @NotEmpty(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY)
    private String username;

    @NotEmpty(message = MsgCode.VALIDATION_USER_PASSWORD_NOT_EMPTY)
    private String password;

}
