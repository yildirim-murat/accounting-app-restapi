package gov.toki.accountingapprestapi.core.api.exception.handlers;

@RequiredArgsConstructor
@ControllerAdvice
@Order(0)
public class PersistenceExceptionHandlers {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ServiceResponse> handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ServiceErrorDataResponse<>(exception, exception.getMessage() == null ? MsgCode.COMMON_ERROR_ENTITY_NOT_FOUND : exception.getMessage()));
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ServiceResponse> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception) {
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ServiceErrorDataResponse<>(exception, MsgCode.COMMON_ERROR_ENTITY_NOT_FOUND));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ServiceResponse> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        Optional<String> code = StringTools.extract(exception.getMessage(), "(fk|uk)_\\w+_\\w+").map(m -> "DB.Constraint." + m);
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ServiceErrorDataResponse<>(exception, code.orElse(MsgCode.COMMON_ERROR_INVALID)));
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<ServiceResponse> handlePersistenceException(PersistenceException exception) {
        return ResponseBuilder.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ServiceErrorDataResponse<>(exception, exception.getLocalizedMessage()));
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ServiceResponse> handleSQLException(SQLException exception) {
        return ResponseBuilder.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ServiceErrorDataResponse<>(exception, exception.getLocalizedMessage()));
    }

}
