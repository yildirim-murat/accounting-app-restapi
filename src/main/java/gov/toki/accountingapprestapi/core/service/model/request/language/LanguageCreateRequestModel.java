package gov.toki.accountingapprestapi.core.service.model.request.language;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_LANGUAGE_NAME_NOT_NULL)
    @Size(min = Validation.Language.MIN_LEN_NAME, max = Validation.Language.MAX_LEN_NAME, message = MsgCode.VALIDATION_LANGUAGE_NAME_SIZE)
    private String name;

    @NotNull(message = MsgCode.VALIDATION_LANGUAGE_LOCAL_NAME_NOT_NULL)
    @Size(min = Validation.Language.MIN_LEN_LOCAL_NAME, max = Validation.Language.MAX_LEN_LOCAL_NAME, message = MsgCode.VALIDATION_LANGUAGE_LOCAL_NAME_SIZE)
    private String localName;

    @NotNull(message = MsgCode.VALIDATION_LANGUAGE_ALPHA_2_NOT_NULL)
    @Pattern(regexp = Validation.Common.RGX_ALPHA_2, message = MsgCode.VALIDATION_LANGUAGE_ALPHA_2_PATTERN)
    private String alpha2;

    @NotNull(message = MsgCode.VALIDATION_LANGUAGE_ALPHA_3_T_NOT_NULL)
    @Pattern(regexp = Validation.Common.RGX_ALPHA_3, message = MsgCode.VALIDATION_LANGUAGE_ALPHA_3_T_PATTERN)
    private String alpha3T;

    private Boolean unlisted;

}
