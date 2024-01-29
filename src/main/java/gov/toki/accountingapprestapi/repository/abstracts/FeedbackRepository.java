package gov.toki.accountingapprestapi.repository.abstracts;


@Repository
public interface FeedbackRepository extends JpaRepositoryAdapter<Feedback, UUID> {

    <P> Page<P> findByReviewed(Boolean reviewed, Pageable pageable, Class<P> projection);

    <P> Page<P> findByTopicContainingIgnoreCase(String containing, Pageable pageable, Class<P> projection);

    <P> Page<P> findByContentContainingIgnoreCase(String containing, Pageable pageable, Class<P> projection);

    @Modifying
    @Query("update Feedback fb set fb.reviewed = :reviewed, fb.reviewer = :#{@securityHelper.currentUsername.orElseThrow()} where fb.id = :id")
    int updateReviewed(UUID id, Boolean reviewed);

}
