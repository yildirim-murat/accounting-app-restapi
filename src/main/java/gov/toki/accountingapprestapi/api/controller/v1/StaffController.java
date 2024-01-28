package gov.toki.accountingapprestapi.api.controller.v1;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/staff")
@Api(tags = "Staff")
public class StaffController {

    private final StaffService staffService;

    @GetMapping("/get/count")
    public ResponseEntity<ServiceResponse> getCount() {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(staffService.getCount());
    }

    @Secured({RoleConst.Name.SUPER_ADMIN})
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid StaffCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(staffService.create(model));
    }

}
