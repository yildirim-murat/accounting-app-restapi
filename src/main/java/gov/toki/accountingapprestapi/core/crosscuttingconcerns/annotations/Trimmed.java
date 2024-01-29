package gov.toki.accountingapprestapi.core.crosscuttingconcerns.annotations;

/**
 * Trims the string fields of the parameters which is subclass of {@link RequestModel}.
 *
 * @implSpec Getter methods of the string fields should have a corresponding setter method
 * @see RequestModel
 */
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface Trimmed {
}
