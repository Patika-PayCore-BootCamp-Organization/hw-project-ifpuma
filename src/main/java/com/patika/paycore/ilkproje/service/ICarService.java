package com.patika.paycore.ilkproje.service;

import com.patika.paycore.ilkproje.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICarService {

    List<Car> getAllCars();
    Optional<Car> getCar(Integer id);
    boolean addCar(Car car);
    boolean deleteCar(Integer id);
    boolean updateCar(Integer id,Car car);


}
