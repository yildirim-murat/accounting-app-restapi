package gov.toki.accountingapprestapi.service.abstracts;


public interface FeedbackService extends EntityService, CreatableService<FeedbackCreateRequestModel>, ReadableService<UUID> {

    <P> ServiceResponse getListByReviewed(Boolean reviewed, PageRequestModel pageRequestModel, Class<P> projection);

    <P> ServiceResponse getListByTopicContains(String containing, PageRequestModel pageRequestModel, Class<P> projection);

    <P> ServiceResponse getListByContentContains(String containing, PageRequestModel pageRequestModel, Class<P> projection);

    ServiceResponse updateReviewed(UUID id, Boolean reviewed);
}
