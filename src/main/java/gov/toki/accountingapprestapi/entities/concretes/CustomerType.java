package gov.toki.accountingapprestapi.entities.concretes;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_customer_type", uniqueConstraints = @UniqueConstraint(columnNames = "uq_name", name = UK.CUSTOMER_TYPE_NAME))
public class CustomerType extends BaseEntity<Integer> {

    @Id
    @Column(name = "id_customer_type", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uq_name", nullable = false, length = Validation.CustomerType.MAX_LEN_NAME)
    private String name;

    @Column(name = "tx_description", nullable = false, length = Validation.CustomerType.MAX_LEN_DESC)
    private String description;

}
