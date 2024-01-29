package gov.toki.accountingapprestapi.core.service.model.response.abstraction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AuditedResponse implements Model {

    @JsonFormat(pattern = "yyyy-MM-dd HH:dd")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:dd")
    private LocalDateTime modifiedAt;

}
