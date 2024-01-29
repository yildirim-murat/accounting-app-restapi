package gov.toki.accountingapprestapi.entities.concretes;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_feedback")
@EntityListeners(FeedbackListener.class)
public class Feedback extends BaseEntity<UUID> {

    @Id
    @Column(name = "id_feedback", nullable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "tx_full_name", length = Validation.Feedback.MAX_LEN_FULL_NAME)
    private String fullName;

    @Column(name = "tx_email", length = Validation.Feedback.MAX_LEN_EMAIL)
    private String email;

    @Column(name = "tx_topic", nullable = false, length = Validation.Feedback.MAX_LEN_TOPIC)
    private String topic;

    @Column(name = "tx_content", nullable = false, length = Validation.Feedback.MAX_LEN_CONTENT)
    private String content;

    @Column(name = "is_reviewed", nullable = false)
    private Boolean reviewed;

    // todo length
    @Column(name = "tx_reviewer", insertable = false, length = Validation.Feedback.MAX_LEN_EMAIL)
    private String reviewer;

}
