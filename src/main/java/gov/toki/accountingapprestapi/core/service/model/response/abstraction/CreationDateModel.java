package gov.toki.accountingapprestapi.core.service.model.response.abstraction;

public interface CreationDateModel extends Model {

    @JsonFormat(pattern = "yyyy-MM-dd HH:dd")
    LocalDateTime getCreatedAt();

}
