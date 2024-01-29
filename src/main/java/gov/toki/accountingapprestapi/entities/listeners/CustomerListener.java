package gov.toki.accountingapprestapi.entities.listeners;

public class CustomerListener {

    @PrePersist
    public void prePersist(Customer target) {
        target.setType(Identifiable.getInstance(CustomerType::new, 1));
        ListenerHelper.addToRoles(target, RoleConst.Id.CUSTOMER);
    }

    @PreRemove
    public void preRemove(Customer target) {
        for (Reservation reservation : target.getReservations())
            target.getReservations().remove(reservation);
    }

}
