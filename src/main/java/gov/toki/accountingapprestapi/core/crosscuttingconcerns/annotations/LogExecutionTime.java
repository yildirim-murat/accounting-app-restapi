package gov.toki.accountingapprestapi.core.crosscuttingconcerns.annotations;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RUNTIME)
public @interface LogExecutionTime {
}
