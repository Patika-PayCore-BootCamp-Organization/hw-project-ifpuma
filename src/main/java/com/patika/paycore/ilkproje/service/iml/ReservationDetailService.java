package com.patika.paycore.ilkproje.service.iml;

import com.patika.paycore.ilkproje.model.ReservationDetail;
import com.patika.paycore.ilkproje.repository.ReservationDetailDal;
import com.patika.paycore.ilkproje.service.IReservationDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationDetailService implements IReservationDetailService {

    private final ReservationDetailDal reservationDetailDal;

    @Override
    public List<ReservationDetail> getAllReservationDetails() {
        return reservationDetailDal.findAll();
    }

    @Override
    public Optional<ReservationDetail> getReservationDetail(Integer id) {
        return reservationDetailDal.findById(id);
    }

    @Override
    public boolean addReservationDetail(ReservationDetail reservationDetail) {
        reservationDetailDal.save(reservationDetail);
        return true;
    }

    @Override
    public boolean deleteReservationDetail(Integer id) {
        reservationDetailDal.deleteById(id);
        return true;
    }

    @Override
    public boolean updateReservationDetail(Integer id, ReservationDetail reservationDetail) {
        reservationDetail.setId(id);
        reservationDetailDal.save(reservationDetail);
        return true;
    }

    //Gelişmiş metotlara devam edilecek
/*    @Override
    public boolean closeStation(Integer station_id) {
        return false;
    }*/
}
