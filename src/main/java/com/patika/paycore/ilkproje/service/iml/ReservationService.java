package com.patika.paycore.ilkproje.service.iml;

import com.patika.paycore.ilkproje.exception.NotFoundException;
import com.patika.paycore.ilkproje.model.Reservation;
import com.patika.paycore.ilkproje.model.Station;
import com.patika.paycore.ilkproje.repository.ReservationDal;
import com.patika.paycore.ilkproje.repository.StationDal;
import com.patika.paycore.ilkproje.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {

    private final ReservationDal reservationDal;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationDal.findAll();
    }

    @Override
    public Reservation getReservation(Integer id) {
        Optional<Reservation> byId = reservationDal.findById(id);
        return byId.orElseThrow(()-> new NotFoundException("Reservation"));
    }

    @Override
    public boolean addReservation(Reservation reservation) {
        reservationDal.save(reservation);
        return true;
    }

    @Override
    public boolean deleteReservation(Integer id) {
        reservationDal.deleteById(id);
        return true;
    }

    @Override
    public boolean updateReservation(Integer id, Reservation reservation) {
        reservation.setId(id);
        reservationDal.save(reservation);
        return true;
    }

    @Override
    public boolean deleteStation(Integer id) {
        reservationDal.deleteById(id);
        return true;
    }
}
