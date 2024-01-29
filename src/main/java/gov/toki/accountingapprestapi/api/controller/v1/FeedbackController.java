package gov.toki.accountingapprestapi.api.controller.v1;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/feedback")
@Api(tags = "Feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(feedbackService.getList(pageRequestModel, FeedbackQuickProjection.class));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick/by_reviewed")
    public ResponseEntity<ServiceResponse> getListQuickByReviewed(
            @RequestParam Boolean reviewed, @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(feedbackService.getListByReviewed(reviewed, pageRequestModel, FeedbackQuickProjection.class));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick/by_topic_contains")
    public ResponseEntity<ServiceResponse> getListByTopicContains(
            @RequestParam String contains, @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(feedbackService.getListByTopicContains(contains, pageRequestModel, FeedbackQuickProjection.class));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick/by_content_contains")
    public ResponseEntity<ServiceResponse> getListByContentContains(
            @RequestParam String contains, @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(feedbackService.getListByContentContains(contains, pageRequestModel, FeedbackQuickProjection.class));
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(
            @RequestBody @Valid FeedbackCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(feedbackService.create(model));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @PutMapping("/update/reviewed")
    public ResponseEntity<ServiceResponse> updateReviewed(
            @RequestParam UUID id, @RequestParam Boolean reviewed) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(feedbackService.updateReviewed(id, reviewed));
    }

}
