package gov.toki.accountingapprestapi.core.service.validation.validators.abstraction;


public abstract class BaseConstraintValidator<C extends Annotation, T> implements ConstraintValidator<C, T> {

    protected C constraint;

    @Override
    public void initialize(C constraint) {
        this.constraint = constraint;
        ConstraintValidator.super.initialize(constraint);
    }

}
