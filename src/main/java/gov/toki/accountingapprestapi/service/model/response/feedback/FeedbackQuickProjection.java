package gov.toki.accountingapprestapi.service.model.response.feedback;


public interface FeedbackQuickProjection extends IdentifiableModel<UUID> {

    String getFullName();

    String getEmail();

    String getTopic();

    String getContent();

    Boolean getReviewed();

    String getReviewer();

}
