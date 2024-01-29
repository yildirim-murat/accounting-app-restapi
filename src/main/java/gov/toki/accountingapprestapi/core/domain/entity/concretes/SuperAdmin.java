package gov.toki.accountingapprestapi.core.domain.entity.concretes;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "tb_super_admin")
@EntityListeners(SuperAdminListener.class)
@PrimaryKeyJoinColumn(name = "id_user", referencedColumnName = "id_user", foreignKey = @ForeignKey(name = FK.SUPER_ADMIN_USER))
@OnDelete(action = OnDeleteAction.CASCADE)
public class SuperAdmin extends User {
}
