package gov.toki.accountingapprestapi.api.controller.v1;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/menu_item")
@Api(tags = "Menu Item")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/one/fully_joined/by_id")
    public ResponseEntity<ServiceResponse> getOneFullyJoined(
            @RequestParam UUID id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(menuItemService.getOneByIdentifier(id, MenuItemQuickProjection.class));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(menuItemService.getList(pageRequestModel, MenuItemQuickProjection.class));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid MenuItemCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(menuItemService.create(model));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/name")
    public ResponseEntity<ServiceResponse> updateName(
            @RequestParam UUID id, @RequestParam String name) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(menuItemService.updateName(id, name));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PutMapping("/update/calories")
    public ResponseEntity<ServiceResponse> updateCalories(
            @RequestParam UUID id, @RequestParam Integer calories) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(menuItemService.updateCalories(id, calories));
    }

}
