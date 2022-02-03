package com.patika.paycore.ilkproje.controller;

import com.patika.paycore.ilkproje.model.Station;
import com.patika.paycore.ilkproje.service.iml.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/station")
public class StationController {

    private final StationService stationService;

    @GetMapping(value = "/all")
    public List<Station> getAll(){
        List<Station> allStations = stationService.getAllStations();
        return allStations.stream().collect(Collectors.toList());
    }

    @GetMapping(value="/{id}")
    public Optional<Station> getByIdStation(@PathVariable @Min(1) Integer id){
        return stationService.getStation(id);
    }

    @PostMapping(value = "/delete")
    public boolean deleteStation(@RequestParam @Min(1) Integer id){
        return stationService.deleteStation(id);
    }

    @PostMapping(value = "/create")
    public boolean saveStation(@RequestBody @Valid Station station){
        return stationService.addStation(station);
    }

    @PostMapping(value = "/update/{id}")
    public boolean updateStation(@PathVariable @Min(1) Integer id,@RequestBody Station station){
        return stationService.updateStation(id,station);
    }
}
