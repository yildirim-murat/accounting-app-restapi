package gov.toki.accountingapprestapi.entities.concretes;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "tb_staff")
@PrimaryKeyJoinColumn(name = "id_user", referencedColumnName = "id_user", foreignKey = @ForeignKey(name = FK.STAFF_USER))
@OnDelete(action = OnDeleteAction.CASCADE)
public class Staff extends User {
}
