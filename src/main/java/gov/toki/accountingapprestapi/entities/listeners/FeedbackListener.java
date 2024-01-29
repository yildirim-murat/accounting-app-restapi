package gov.toki.accountingapprestapi.entities.listeners;

public class FeedbackListener {

    @PrePersist
    public void prePersist(Feedback target) {
        target.setReviewed(false);
        target.setReviewer(null);
    }

}
