package gov.toki.accountingapprestapi.entities.concretes;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "tb_customer",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "uq_card_no", name = UK.CUSTOMER_CARD_NO),
                @UniqueConstraint(columnNames = "uq_tckn", name = UK.CUSTOMER_TCKN),
        }
)
@EntityListeners(CustomerListener.class)
@PrimaryKeyJoinColumn(name = "id_user", referencedColumnName = "id_user", foreignKey = @ForeignKey(name = FK.CUSTOMER_USER))
@OnDelete(action = OnDeleteAction.CASCADE)
public class Customer extends User {

    @Column(name = "uq_tckn", nullable = false, length = Validation.Customer.MAX_LEN_TCKN)
    private String tckn;

    @Column(name = "uq_card_no", nullable = true, length = Validation.Customer.MAX_LEN_CARD_NO)
    private String cardNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_customer_type", nullable = false, foreignKey = @ForeignKey(name = FK.CUSTOMER_CUSTOMER_TYPE))
    private CustomerType type;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Reservation> reservations;

}
