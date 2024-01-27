package gov.toki.accountingapprestapi.core.service.model.response.abstraction;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;

import java.time.LocalDateTime;

public interface ModificationDateModel extends Model {

    @JsonFormat(pattern = "yyyy-MM-dd HH:dd")
    LocalDateTime getModifiedAt();

}
