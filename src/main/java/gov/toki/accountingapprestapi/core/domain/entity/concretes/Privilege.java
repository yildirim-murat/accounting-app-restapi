package gov.toki.accountingapprestapi.core.domain.entity.concretes;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_privilege", uniqueConstraints = @UniqueConstraint(columnNames = "uq_name", name = UK.PRIVILEGE_NAME))
public class Privilege extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_privilege", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "uq_name", nullable = false, length = Validation.Privilege.MAX_LEN_NAME)
    private String name;

    @Column(name = "tx_description", nullable = false, length = Validation.Privilege.MAX_LEN_DESC)
    private String description;

}
