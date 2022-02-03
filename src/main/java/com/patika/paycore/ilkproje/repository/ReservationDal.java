package com.patika.paycore.ilkproje.repository;

import com.patika.paycore.ilkproje.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDal extends JpaRepository<Reservation,Integer> {
}
