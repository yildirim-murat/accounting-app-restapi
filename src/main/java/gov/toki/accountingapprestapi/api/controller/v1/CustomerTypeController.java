package gov.toki.accountingapprestapi.api.controller.v1;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/customer_type")
@Api(tags = "Customer Type")
public class CustomerTypeController {

    private final CustomerTypeService customerTypeService;

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerTypeService.getList(pageRequestModel, CustomerTypeQuickProjection.class));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid CustomerTypeCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(customerTypeService.create(model));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/name")
    public ResponseEntity<ServiceResponse> updateName(
            @RequestParam Integer id,
            @RequestParam @Size(min = Validation.CustomerType.MIN_LEN_NAME, max = Validation.CustomerType.MAX_LEN_NAME, message = MsgCode.VALIDATION_CUSTOMER_TYPE_NAME_SIZE) String name) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerTypeService.updateName(id, name));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/description")
    public ResponseEntity<ServiceResponse> updateDescription(
            @RequestParam Integer id,
            @RequestParam @Size(min = Validation.CustomerType.MIN_LEN_DESC, max = Validation.CustomerType.MAX_LEN_DESC, message = MsgCode.VALIDATION_CUSTOMER_TYPE_DESCRIPTION_SIZE) String description) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(customerTypeService.updateDesc(id, description));
    }

}
