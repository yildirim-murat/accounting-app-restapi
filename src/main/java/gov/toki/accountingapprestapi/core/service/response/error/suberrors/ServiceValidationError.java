package gov.toki.accountingapprestapi.core.service.response.error.suberrors;
public record ServiceValidationError(
        String field,
        @JsonFormat(shape = JsonFormat.Shape.STRING) Object rejectedValue,
        String code,
        String message) implements ServiceSubError {
}
