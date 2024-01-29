package gov.toki.accountingapprestapi.core.service.model.response.user;

public interface UserAuthProjection extends CreationDateModel, ModificationDateModel, IdentifiableModel<UUID> {

    String getUsername();

    String getPhoneNumber();

    String getFirstName();

    String getLastName();

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getBirthDate();

    Collection<RoleJoinedProjection> getRoles();

}
