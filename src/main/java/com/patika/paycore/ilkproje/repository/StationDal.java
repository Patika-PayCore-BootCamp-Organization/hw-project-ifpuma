package com.patika.paycore.ilkproje.repository;

import com.patika.paycore.ilkproje.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationDal extends JpaRepository<Station, Integer> {
    Station findStationByProvince(String province);
}
