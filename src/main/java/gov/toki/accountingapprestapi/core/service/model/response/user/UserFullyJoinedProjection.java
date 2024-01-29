package gov.toki.accountingapprestapi.core.service.model.response.user;

public interface UserFullyJoinedProjection extends CreationDateModel, ModificationDateModel, IdentifiableModel<UUID> {

    String getUsername();

    String getPhoneNumber();

    LanguageQuickProjection getLanguage();

    String getFirstName();

    String getLastName();

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getBirthDate();

    Collection<RoleJoinedProjection> getRoles();

}
