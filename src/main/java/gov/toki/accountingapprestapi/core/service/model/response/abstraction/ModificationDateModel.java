package gov.toki.accountingapprestapi.core.service.model.response.abstraction;

public interface ModificationDateModel extends Model {

    @JsonFormat(pattern = "yyyy-MM-dd HH:dd")
    LocalDateTime getModifiedAt();

}
