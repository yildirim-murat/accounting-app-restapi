package gov.toki.accountingapprestapi.core.api.exception.handlers;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class FallbackExceptionHandlers {

    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity<ServiceResponse> handlePropertyReferenceException(PropertyReferenceException exception) {
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ServiceErrorDataResponse<>(exception, exception.getLocalizedMessage()));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ServiceResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ServiceErrorDataResponse<>(exception, "Please enter the " + exception.getParameterName() + " parameter of type " + exception.getParameterType()));
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<Object> handleTypeMismatchException(final TypeMismatchException exception) {
        final String message = exception.getValue() + " value for " + exception.getPropertyName() + " should be of type " + exception.getRequiredType();
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ServiceErrorDataResponse<>(exception, message));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException exception) {
        Set<HttpMethod> supportedMethods = exception.getSupportedHttpMethods();
        final StringBuilder builder = new StringBuilder();
        if (supportedMethods != null) {
            int size = supportedMethods.size();
            builder.append('\'').append(exception.getMethod()).append('\'').append(" method is not supported for this request. Supported method");
            if (size == 1) builder.append(" is ");
            else builder.append("s are ");
            short counter = 0;
            for (HttpMethod httpMethod : supportedMethods) {
                if (counter == size - 1 && size != 1) builder.append(" and ");
                else if (counter != 0 && size != 1) builder.append(", ");
                builder.append('\'').append(httpMethod).append('\'');
                counter++;
            }
        } else builder.append("There is no supported method for this request.");
        return ResponseBuilder.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(new ServiceErrorDataResponse<>(exception, builder.toString()));
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    public ResponseEntity<Object> handleMissingServletRequestPartException(final MissingServletRequestPartException exception) {
        final String message = exception.getRequestPartName() + " part is missing";
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ServiceErrorDataResponse<>(exception, message));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException exception) {
        final String message = exception.getName() + " should be of type " + Objects.requireNonNull(exception.getRequiredType()).getName();
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ServiceErrorDataResponse<>(exception, message));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    protected ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException exception) {
        final String message = "No handler found for " + exception.getHttpMethod() + " " + exception.getRequestURL();
        return ResponseBuilder.status(HttpStatus.NOT_FOUND)
                .body(new ServiceErrorDataResponse<>(exception, message));
    }

    @ExceptionHandler(NestedRuntimeException.class)
    public ResponseEntity<ServiceResponse> handleNestedRuntimeException(NestedRuntimeException exception) {
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ServiceErrorDataResponse<>(exception, MsgCode.COMMON_ERROR));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ServiceResponse> handleThrowable(Throwable exception) {
        return ResponseBuilder.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ServiceErrorDataResponse<>(exception, exception.getMessage()));
    }

}
