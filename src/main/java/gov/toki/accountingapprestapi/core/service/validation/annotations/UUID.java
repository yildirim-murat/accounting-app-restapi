package gov.toki.accountingapprestapi.core.service.validation.annotations;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp = Validation.Common.RGX_UUID, message = MsgCode.VALIDATION_DEFAULT_UUID)
public @interface UUID {
}
