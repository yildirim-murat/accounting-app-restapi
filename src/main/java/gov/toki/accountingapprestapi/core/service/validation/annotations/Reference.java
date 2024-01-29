package gov.toki.accountingapprestapi.core.service.validation.annotations;

@Constraint(validatedBy = ReferenceValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Reference.List.class)
public @interface Reference {

    /**
     * Entity class which wanted to be validated.
     */
    Class<? extends Entity> entity();

    /**
     * Field name of the entity which wanted to be validated.
     */
    String fieldName() default "id";

    String message() default MsgCode.VALIDATION_DEFAULT_REFERENCE;

    Class<? extends Payload>[] payload() default {};

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @interface List {
        Reference[] value();
    }

}
