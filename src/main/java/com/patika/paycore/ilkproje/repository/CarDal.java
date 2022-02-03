package com.patika.paycore.ilkproje.repository;

import com.patika.paycore.ilkproje.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDal extends JpaRepository<Car,Integer> {
}
