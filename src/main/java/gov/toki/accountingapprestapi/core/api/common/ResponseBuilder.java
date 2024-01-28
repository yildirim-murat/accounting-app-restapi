package gov.toki.accountingapprestapi.core.api.common;

public class ResponseBuilder<R extends ServiceResponse> extends ResponseEntity<R> {

    public ResponseBuilder() {
        super(HttpStatus.OK);
    }

    public static BodyBuilder status(HttpStatus status) {
        return ResponseEntity.status(status);
    }

}
