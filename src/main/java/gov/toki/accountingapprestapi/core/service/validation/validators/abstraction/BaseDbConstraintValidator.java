package gov.toki.accountingapprestapi.core.service.validation.validators.abstraction;

public abstract class BaseDbConstraintValidator<C extends Annotation, T> extends BaseConstraintValidator<C, T> {

    @Setter(onMethod = @__(@Autowired))
    protected DbValidationHelper dbValidationHelper;

}
