package gov.toki.accountingapprestapi.core.service.validation.validators;

public class TCKNStringValidator extends BaseConstraintValidator<TCKN, String> {

    @Override
    public boolean isValid(String tckn, ConstraintValidatorContext constraintValidatorContext) {
        if (tckn == null) return true;
        if (!tckn.matches(Validation.Customer.RGX_TCKN)) return false;
        return TCKNHelper.isValid(Long.parseLong(tckn));
    }

}
