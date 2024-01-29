package gov.toki.accountingapprestapi.core.service.model.response.user;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends AuditedResponse {

    private UUID id;

    private String username;

    private String phoneNumber;

    private LanguageResponse language;

    private String firstName;

    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private Set<RoleResponse> roles;

}
