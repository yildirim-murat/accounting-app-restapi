package gov.toki.accountingapprestapi.api.controller.v1;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/customer")
@Api(tags = "Customer")
public class CustomerController {

    private final CustomerService customerService;
    private final JwtTokenHelper jwtTokenHelper;

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerService.getList(pageRequestModel, CustomerQuickProjection.class));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#username) or hasAnyAuthority(T(edu.estu.estufastingrestapi.core.domain.constants.RoleConst$Name).SUPER_ADMIN)")
    @GetMapping("/get/one/fully_joined/by_username")
    public ResponseEntity<ServiceResponse> getByUsername(
            @RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerService.getOneByIdentifier(username, CustomerFullyJoinedProjection.class));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid CustomerCreateRequestModel model) {
        ServiceDataResponse<?> serviceResponse = customerService.create(model);
        return ResponseBuilder.status(HttpStatus.CREATED)
                .header(HttpHeaders.AUTHORIZATION, jwtTokenHelper.generateToken(serviceResponse.getData()))
                .body(serviceResponse);
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @PutMapping("/update/type")
    public ResponseEntity<ServiceResponse> updateType(
            @RequestParam UUID id, @RequestParam Integer typeId) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerService.updateType(id, typeId));
    }

}
