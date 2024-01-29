package gov.toki.accountingapprestapi.core.service.validation.annotations;

/**
 * Turkish republic identification number
 */
@Constraint(validatedBy = {TCKNLongValidator.class, TCKNStringValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TCKN {

    String message() default MsgCode.VALIDATION_DEFAULT_TCKN;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
