package gov.toki.accountingapprestapi.core.service.model.response.language;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageResponse implements Model {

    private Integer id;

    private String name;

    private String localName;

    private String alpha2;

    private String alpha3T;

    private Boolean unlisted;

    private Boolean supported;

}
