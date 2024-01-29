package gov.toki.accountingapprestapi.core.service.validation.annotations;


@Constraint(validatedBy = MaxCollectionSizeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxCollectionSize {

    int max() default 10;

    String message() default MsgCode.VALIDATION_DEFAULT_MAX_COLLECTION_SIZE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
