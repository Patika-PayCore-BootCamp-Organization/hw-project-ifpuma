package com.patika.paycore.ilkproje.service.iml;

import com.patika.paycore.ilkproje.model.Car;
import com.patika.paycore.ilkproje.repository.CarDal;
import com.patika.paycore.ilkproje.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {

    private final CarDal carDal;

    @Override
    public List<Car> getAllCars() {
        return carDal.findAll();
    }

    @Override
    public Optional<Car> getCar(Integer id) {
        return carDal.findById(id);
    }

    @Override
    public boolean addCar(Car car) {
        carDal.save(car);
        return true;
    }

    @Override
    public boolean deleteCar(Integer id) {
        carDal.deleteById(id);
        return true;
    }

    @Override
    public boolean updateCar(Integer id, Car car) {
        car.setId(id);
        carDal.save(car);
        return true;
    }
}
