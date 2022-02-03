package com.patika.paycore.ilkproje.repository;

import com.patika.paycore.ilkproje.model.ReservationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDetailDal extends JpaRepository<ReservationDetail,Integer> {
}
