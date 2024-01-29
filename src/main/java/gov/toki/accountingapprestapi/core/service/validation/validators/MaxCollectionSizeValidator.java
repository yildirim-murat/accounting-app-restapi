package gov.toki.accountingapprestapi.core.service.validation.validators;

public class MaxCollectionSizeValidator extends BaseConstraintValidator<MaxCollectionSize, Collection<?>> {

    @Override
    public boolean isValid(Collection<?> values, ConstraintValidatorContext context) {
        if (values == null) return true;
        return values.size() <= constraint.max();
    }

}