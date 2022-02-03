package com.patika.paycore.ilkproje.service;

import com.patika.paycore.ilkproje.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IReservationService {

    List<Reservation> getAllReservations();

    Optional<Reservation> getReservation(Integer id);

    boolean addReservation(Reservation reservation);

    boolean deleteReservation(Integer id);

    boolean updateReservation(Integer id,Reservation reservation);

}
