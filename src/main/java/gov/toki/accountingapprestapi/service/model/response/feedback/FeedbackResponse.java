package gov.toki.accountingapprestapi.service.model.response.feedback;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackResponse extends AuditedResponse {

    private UUID id;

    private String fullName;

    private String email;

    private String topic;

    private String content;

    private Boolean reviewed;

    private String reviewer;

}
