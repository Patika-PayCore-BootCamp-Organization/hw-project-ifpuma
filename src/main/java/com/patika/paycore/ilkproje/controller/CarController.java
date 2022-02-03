package com.patika.paycore.ilkproje.controller;

import com.patika.paycore.ilkproje.model.Car;
import com.patika.paycore.ilkproje.model.Station;
import com.patika.paycore.ilkproje.service.iml.CarService;
import com.patika.paycore.ilkproje.service.iml.StationService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {


    private final CarService carService;

    @GetMapping(value = "/all")
    public List<Car> getAll(){
        List<Car> allCars = carService.getAllCars();
        return allCars.stream().collect(Collectors.toList());
    }

    @GetMapping(value="/{id}")
    public Optional<Car> getByIdCar(@PathVariable @Min(1) Integer id){
        return carService.getCar(id);
    }

    @PostMapping(value = "/delete")
    public boolean deleteCar(@RequestParam @Min(1) Integer id){
        return carService.deleteCar(id);
    }

    @PostMapping(value = "/create")
    public boolean saveCar(@RequestBody @Valid Car car){
        return carService.addCar(car);
    }

    @PostMapping(value = "/update/{id}")
    public boolean updateCar(@PathVariable @Min(1) Integer id,@RequestBody Car car){
        return carService.updateCar(id,car);
    }
}
