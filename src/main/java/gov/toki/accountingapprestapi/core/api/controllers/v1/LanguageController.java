package gov.toki.accountingapprestapi.core.api.controllers.v1;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/language")
@Api(tags = "Language")
public class LanguageController {

    private final LanguageService languageService;

    @Secured(RoleConst.Name.USER)
    @GetMapping("/get/one/by_id")
    public ResponseEntity<ServiceResponse> getById(@RequestParam Integer id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(languageService.getOneByIdentifier(id, LanguageQuickProjection.class));
    }

    @Secured(RoleConst.Name.USER)
    @GetMapping("/get/one/by_alpha_2")
    public ResponseEntity<ServiceResponse> getByAlpha2(@RequestParam String alpha2) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(languageService.getByAlpha2(alpha2, LanguageQuickProjection.class));
    }

    @Secured(RoleConst.Name.USER)
    @GetMapping("/get/list")
    public ResponseEntity<ServiceResponse> get(@ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(languageService.getList(pageRequestModel, LanguageQuickProjection.class));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid LanguageCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(languageService.create(model));
    }

}
