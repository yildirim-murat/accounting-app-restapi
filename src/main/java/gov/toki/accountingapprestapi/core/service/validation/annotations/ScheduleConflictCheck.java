package gov.toki.accountingapprestapi.core.service.validation.annotations;

/**
 * Field types should be {@link Comparable}
 */
@Constraint(validatedBy = ScheduleConflictCheckValidator.class)
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface ScheduleConflictCheck {

    String message() default MsgCode.VALIDATION_DEFAULT_SCHEDULE_CONFLICT_CHECK;

    String startFieldName() default "start";

    String endFieldName() default "end";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
