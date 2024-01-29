package gov.toki.accountingapprestapi.core.service.validation.validators;

@Component
public class ReferenceValidator extends BaseDbConstraintValidator<Reference, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return true;
        return dbValidationHelper.existsByField(constraint.entity(), constraint.fieldName(), value);
    }

}
