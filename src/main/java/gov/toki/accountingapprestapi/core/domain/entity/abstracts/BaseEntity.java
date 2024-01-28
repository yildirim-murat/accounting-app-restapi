package gov.toki.accountingapprestapi.core.domain.entity.abstracts;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
@EntityListeners({CreateAuditableListener.class, UpdateAuditableListener.class})
public abstract class BaseEntity<ID> implements Entity, Identifiable<ID>, CreateAuditable, UpdateAuditable {

    @Column(name = "dt_created", nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @Column(name = "dt_modified", insertable = false)
    protected LocalDateTime modifiedAt;

    @Column(name = "tx_creator", nullable = false, updatable = false, length = Validation.User.MAX_LEN_EMAIL)
    protected String creator;

    @Column(name = "tx_modifier", insertable = false, length = Validation.User.MAX_LEN_EMAIL)
    protected String modifier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BaseEntity<?> baseEntity = (BaseEntity<?>) o;
        return getId() != null && Objects.equals(getId(), baseEntity.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
