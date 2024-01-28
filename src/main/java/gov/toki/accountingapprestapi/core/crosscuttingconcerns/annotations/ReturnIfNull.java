package gov.toki.accountingapprestapi.core.crosscuttingconcerns.annotations;

@Target(ElementType.PARAMETER)
@Retention(RUNTIME)
public @interface ReturnIfNull {
}
