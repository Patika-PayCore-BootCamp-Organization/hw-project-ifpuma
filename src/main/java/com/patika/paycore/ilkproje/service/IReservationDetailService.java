package com.patika.paycore.ilkproje.service;

import com.patika.paycore.ilkproje.model.ReservationDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IReservationDetailService {

    List<ReservationDetail> getAllReservationDetails();

    Optional<ReservationDetail> getReservationDetail(Integer id);

    boolean addReservationDetail(ReservationDetail reservationDetail);

    boolean deleteReservationDetail(Integer id);

    boolean updateReservationDetail(Integer id,ReservationDetail reservationDetail);

    //temel metotlar dışındakiler
   // boolean closeStation(Integer station_id);

}
