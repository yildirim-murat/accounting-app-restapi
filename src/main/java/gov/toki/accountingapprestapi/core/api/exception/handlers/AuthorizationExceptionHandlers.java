package gov.toki.accountingapprestapi.core.api.exception.handlers;

@RequiredArgsConstructor
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthorizationExceptionHandlers {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ServiceResponse> handleAccessDeniedException(AccessDeniedException exception) {
        return ResponseBuilder.status(HttpStatus.UNAUTHORIZED)
                .body(new ServiceErrorDataResponse<>(exception, MsgCode.SECURITY_ACCESS_IS_DENIED));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ServiceResponse> handleAuthenticationException(AuthenticationException exception) {
        return ResponseBuilder.status(HttpStatus.UNAUTHORIZED)
                .body(new ServiceErrorDataResponse<>(exception, MsgCode.SECURITY_ACCESS_IS_DENIED));
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ServiceResponse> handleJwtException(ExpiredJwtException exception) {
        return ResponseBuilder.status(HttpStatus.UNAUTHORIZED)
                .body(new ServiceErrorDataResponse<>(exception, MsgCode.SECURITY_RE_LOGIN_JWT_EXPIRED));
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ServiceResponse> handleJwtException(JwtException exception) {
        return ResponseBuilder.status(HttpStatus.UNAUTHORIZED)
                .body(new ServiceErrorDataResponse<>(exception, MsgCode.COMMON_ERROR_AUTHENTICATION));
    }

}
