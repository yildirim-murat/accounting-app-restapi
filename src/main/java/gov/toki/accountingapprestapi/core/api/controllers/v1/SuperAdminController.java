package gov.toki.accountingapprestapi.core.api.controllers.v1;


@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/super_admin")
@Api(tags = "Super Admin")
public class SuperAdminController {

    private final SuperAdminService superAdminService;
    private final JwtTokenHelper jwtTokenHelper;

    @PreAuthorize("@securityHelper.isLoggedInUser(#username)")
    @GetMapping("/get/one/fully_joined/by_username")
    public ResponseEntity<ServiceResponse> getOneFullyJoinedByUsername(@RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getOneFullyJoinedByUsername(username, SuperAdminFullyJoinedProjection.class));
    }

    @PreAuthorize("@securityHelper.isLoggedInUser(#username)")
    @GetMapping("/get/one/semi_joined/by_username")
    public ResponseEntity<ServiceResponse> getOneSemiJoinedByUsername(@RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getOneByIdentifier(username, SuperAdminSemiJoinedProjection.class));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(@ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getList(pageRequestModel, SuperAdminQuickProjection.class));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @GetMapping("/get/list/semi_joined")
    public ResponseEntity<ServiceResponse> getListSemiJoined(@ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(superAdminService.getList(pageRequestModel, SuperAdminSemiJoinedProjection.class));
    }

    @PreAuthorize("!@securityHelper.isLoggedInUser(#model.username)")
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid SuperAdminCreateRequestModel model) {
        ServiceDataResponse<?> serviceResponse = superAdminService.create(model);
        return ResponseBuilder.status(HttpStatus.CREATED)
                .header(HttpHeaders.AUTHORIZATION, jwtTokenHelper.generateToken(serviceResponse.getData()))
                .body(serviceResponse);
    }

}
