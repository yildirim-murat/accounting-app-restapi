package gov.toki.accountingapprestapi.service.model.response.customer;

public interface CustomerQuickProjection extends UserFullyJoinedProjection {

    String getTckn();

    String getCardNo();

    CustomerTypeQuickProjection getType();

}
