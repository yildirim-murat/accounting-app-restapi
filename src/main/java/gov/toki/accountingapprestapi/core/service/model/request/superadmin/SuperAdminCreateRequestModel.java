package gov.toki.accountingapprestapi.core.service.model.request.superadmin;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuperAdminCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_USER_EMAIL_NOT_EMPTY)
    @Pattern(regexp = Validation.User.RGX_EMAIL, message = MsgCode.VALIDATION_USER_EMAIL_PATTERN)
    private String username;

    @NotNull(message = MsgCode.VALIDATION_USER_PASSWORD_NOT_NULL)
    @Size(min = Validation.User.MIN_LEN_PW, max = Validation.User.MAX_LEN_PW, message = MsgCode.VALIDATION_USER_PASSWORD_SIZE)
    private String password;

    @NotNull(message = MsgCode.VALIDATION_USER_PHONE_NUMBER_NOT_NULL)
    @Pattern(regexp = Validation.User.RGX_PHONE_NUMBER, message = MsgCode.VALIDATION_USER_PHONE_NUMBER_PATTERN)
    private String phoneNumber;

    @NotNull(message = MsgCode.VALIDATION_USER_LANGUAGE_ID_NOT_NULL)
    private Integer languageId;

    @NotNull(message = MsgCode.VALIDATION_USER_FIRST_NAME_NOT_NULL)
    @Size(min = Validation.User.MIN_LEN_FIRST_NAME, max = Validation.User.MAX_LEN_FIRST_NAME, message = MsgCode.VALIDATION_USER_FIRST_NAME_SIZE)
    private String firstName;

    @NotNull(message = MsgCode.VALIDATION_USER_LAST_NAME_NOT_NULL)
    @Size(min = Validation.User.MIN_LEN_LAST_NAME, max = Validation.User.MAX_LEN_LAST_NAME, message = MsgCode.VALIDATION_USER_LAST_NAME_SIZE)
    private String lastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = MsgCode.VALIDATION_USER_BIRTH_DATE_NOT_NULL)
    @Past(message = MsgCode.VALIDATION_USER_BIRTH_DATE_PAST)
    private LocalDate birthDate;

}
