package gov.toki.accountingapprestapi.core.api.controllers.v1;

@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Api(tags = "Authentication")
public class AuthController {

    private final JwtTokenHelper jwtTokenHelper;
    private final UserService userService;
    private final CustomerService customerService;
    private final BCryptPasswordEncoder passwordEncoder;

    @PreAuthorize("@staffRepository.existsByUsername(#model.identifier) or @superAdminRepository.existsByUsername(#model.identifier)")
    @PostMapping("/login/management")
    @SneakyThrows(BadCredentialsException.class)
    public ResponseEntity<ServiceResponse> loginManagement(@RequestBody @Valid ManagementLoginRequestModel model) {
        String password = userService.getPasswordByUsername(model.getIdentifier());
        checkPassword(password, model.getPassword());

        UserAuthProjection user = userService.getUserForLogin(model.getIdentifier());
        return ResponseBuilder.status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, jwtTokenHelper.generateToken(user))
                .body(new ServiceSuccessDataResponse<>(user, MsgCode.COMMON_SUCCESS));
    }

    @PostMapping("/login/customer")
    @SneakyThrows(BadCredentialsException.class)
    public ResponseEntity<ServiceResponse> loginCustomer(@RequestBody @Valid CustomerLoginRequestModel model) {
        boolean isTckn = model.getIdentifier().matches(Validation.Customer.RGX_TCKN);
        String password = isTckn ?
                customerService.getPasswordByTckn(model.getIdentifier()) :
                userService.getPasswordByUsername(model.getIdentifier());
        checkPassword(password, model.getPassword());

        UserAuthProjection user = isTckn ?
                customerService.getCustomerForLoginByTckn(model.getIdentifier()) :
                userService.getUserForLogin(model.getIdentifier());
        return ResponseBuilder.status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, jwtTokenHelper.generateToken(user))
                .body(new ServiceSuccessDataResponse<>(user, MsgCode.COMMON_SUCCESS));
    }

    private void checkPassword(String real, String given) {
        if (real == null)
            throw new UsernameNotFoundException(MsgCode.SECURITY_LOGIN_WRONG_USERNAME);
        if (!passwordEncoder.matches(given, real))
            throw new BadCredentialsException(MsgCode.SECURITY_LOGIN_WRONG_PASSWORD);
    }
}
