package gov.toki.accountingapprestapi.service.concretes;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationServiceImpl extends BaseReadableServiceImpl<Reservation, UUID> implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CateringRepository cateringRepository;
    private final MapStructMapper<ReservationCreateRequestModel, Reservation> createRequestMapper;
    private final MapStructMapper<Reservation, ReservationResponse> responseMapper;

    private Reservation createSimple(ReservationCreateRequestModel model) {
        if (cateringRepository.existsByIdAndDateBefore(model.getCateringId(), LocalDate.now()))
            throw new IllegalArgumentException(MsgCode.VALIDATION_RESERVATION_CATERING_DATE_FUTURE);
        return EntityServiceHelper.saveAndRefresh(repository, createRequestMapper.map(model));
    }

    @Override
    public ServiceDataResponse<Model> create(ReservationCreateRequestModel model) {
        return new ServiceSuccessDataResponse<>(responseMapper.map(createSimple(model)), MsgCode.CUSTOMER_RESERVATION_MAKE_SUCCESS);
    }

    @Override
    public ServiceDataResponse<List<?>> createMultiple(List<ReservationCreateRequestModel> models) {
        List<ReservationResponse> reservationResponseList = new LinkedList<>();
        for (ReservationCreateRequestModel model : models)
            reservationResponseList.add(responseMapper.map(createSimple(model)));
        return new ServiceSuccessDataResponse<>(reservationResponseList, MsgCode.CUSTOMER_RESERVATION_MAKE_SUCCESS);
    }

    @Override
    public ServiceResponse updatePaid(UUID id, Boolean paid) {
        return ResponseHelper.getResponseBySuccess(reservationRepository.updatePaid(id, paid), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse completePaymentMultiple(List<UUID> ids) {
        boolean success = true;
        for (UUID id : ids)
            if (reservationRepository.updatePaid(id, true) == 0) success = false;
        return ResponseHelper.getResponseBySuccess(success, MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse delete(UUID id) {
        repository.deleteById(id);
        return new ServiceSuccessResponse(MsgCode.CUSTOMER_RESERVATION_CANCEL_SUCCESS);
    }

}
