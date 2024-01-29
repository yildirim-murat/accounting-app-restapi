package gov.toki.accountingapprestapi.core.service.validation.validators;

public class ScheduleConflictCheckValidator extends BaseConstraintValidator<ScheduleConflictCheck, Object> {

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object == null) return true;
        String startGetterName = ReflectionHelper.getGetterNameOfFieldName(constraint.startFieldName());
        String endGetterName = ReflectionHelper.getGetterNameOfFieldName(constraint.endFieldName());
        Comparable start = ReflectionHelper.getFieldValueByGetter(object, startGetterName, Comparable.class).orElse(null);
        Comparable<?> end = ReflectionHelper.getFieldValueByGetter(object, endGetterName, Comparable.class).orElse(null);
        if (start == null || end == null) return true;
        else return start.compareTo(end) < 0;
    }

}
