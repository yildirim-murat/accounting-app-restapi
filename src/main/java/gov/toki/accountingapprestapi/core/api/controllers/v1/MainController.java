package gov.toki.accountingapprestapi.core.api.controllers.v1;

@RestController
@Api(tags = "Main")
public class MainController implements ErrorController {

    @RequestMapping("/")
    public void redirectToSwaggerUI(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html#");
    }

    @RequestMapping("/error")
    public ResponseEntity<ServiceErrorResponse> handleError(HttpServletRequest request) {
        HttpStatus httpStatus = Optional
                .of(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE))
                .flatMap(sub -> Optional.of(sub.toString()))
                .flatMap(sub -> Optional.of(Integer.parseInt(sub)))
                .map(HttpStatus::resolve)
                .orElse(HttpStatus.BAD_REQUEST);
        return ResponseBuilder.status(httpStatus)
                .body(new ServiceErrorResponse());
    }

}
