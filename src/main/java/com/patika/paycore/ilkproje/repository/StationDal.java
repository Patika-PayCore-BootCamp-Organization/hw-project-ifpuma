package com.patika.paycore.ilkproje.repository;

import com.patika.paycore.ilkproje.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationDal extends JpaRepository<Station, Integer> {
}
