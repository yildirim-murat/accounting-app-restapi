package gov.toki.accountingapprestapi.service.model.response.customer;

public interface CustomerFullyJoinedProjection extends UserFullyJoinedProjection {

    String getTckn();

    String getCardNo();

    CustomerTypeQuickProjection getType();

    Collection<ReservationSemiJoinedProjection> getReservations();

}
