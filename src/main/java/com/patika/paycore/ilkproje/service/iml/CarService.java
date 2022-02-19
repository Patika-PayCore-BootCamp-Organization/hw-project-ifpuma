package com.patika.paycore.ilkproje.service.iml;

import com.patika.paycore.ilkproje.exception.DataIntegrityViolationException;
import com.patika.paycore.ilkproje.exception.NotFoundException;
import com.patika.paycore.ilkproje.model.Car;
import com.patika.paycore.ilkproje.model.Client;
import com.patika.paycore.ilkproje.repository.CarDal;
import com.patika.paycore.ilkproje.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {

    private final CarDal carDal;
    private final ClientService clientService;

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
    public Boolean deleteCar(Integer id) {
        Car car = carDal.getById(id);
        try {
            Boolean isCarTakenByClient = car.getClients().stream().anyMatch(c -> car.getClients().equals(c));
            if (!isCarTakenByClient)
                carDal.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new DataIntegrityViolationException(car.getId());
        }
    }
    @Override
    public boolean updateCar(Integer id, Car car) {
        car.setId(id);
        carDal.save(car);
        return true;
    }
}
