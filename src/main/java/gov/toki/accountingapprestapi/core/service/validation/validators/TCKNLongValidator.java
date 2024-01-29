package gov.toki.accountingapprestapi.core.service.validation.validators;

public class TCKNLongValidator extends BaseConstraintValidator<TCKN, Long> {

    @Override
    public boolean isValid(Long tckn, ConstraintValidatorContext constraintValidatorContext) {
        if (tckn == null) return true;
        return TCKNHelper.isValid(tckn);
    }

}
