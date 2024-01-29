package gov.toki.accountingapprestapi.core.service.model.request.language;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageUpdateRequestModel implements IdentifiableModel<Integer>, RequestModel {

    @NotNull(message = MsgCode.VALIDATION_LANGUAGE_ID_NOT_NULL)
    private Integer id;

    @Size(min = Validation.Language.MIN_LEN_NAME, max = Validation.Language.MAX_LEN_NAME, message = MsgCode.VALIDATION_LANGUAGE_NAME_SIZE)
    private String name;

    @Size(min = Validation.Language.MIN_LEN_LOCAL_NAME, max = Validation.Language.MAX_LEN_LOCAL_NAME, message = MsgCode.VALIDATION_LANGUAGE_LOCAL_NAME_SIZE)
    private String localName;

    @Pattern(regexp = Validation.Common.RGX_ALPHA_2, message = MsgCode.VALIDATION_LANGUAGE_ALPHA_2_PATTERN)
    private String alpha2;

    @Pattern(regexp = Validation.Common.RGX_ALPHA_3, message = MsgCode.VALIDATION_LANGUAGE_ALPHA_3_T_PATTERN)
    private String alpha3T;

    private Boolean unlisted;

    private Boolean supported;

}
