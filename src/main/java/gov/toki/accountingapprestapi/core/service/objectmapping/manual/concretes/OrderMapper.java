package gov.toki.accountingapprestapi.core.service.objectmapping.manual.concretes;


@Component
public class OrderMapper implements ManualMapper<OrderRequestModel, Sort.Order> {

    @Override
    public Sort.Order map(@ReturnIfNull OrderRequestModel orderModel) {
        return orderModel.isIgnoreCase() ?
                new Sort.Order(orderModel.getDirection(), orderModel.getProperty(), orderModel.getNullHandling()).ignoreCase() :
                new Sort.Order(orderModel.getDirection(), orderModel.getProperty(), orderModel.getNullHandling());
    }

}
