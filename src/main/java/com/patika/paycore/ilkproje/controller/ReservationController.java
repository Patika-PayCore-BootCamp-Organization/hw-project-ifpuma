package com.patika.paycore.ilkproje.controller;

import com.patika.paycore.ilkproje.model.Reservation;
import com.patika.paycore.ilkproje.service.iml.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping(value = "/all")
    public List<Reservation> getAll(){
        List<Reservation> allReservations = reservationService.getAllReservations();
        return allReservations.stream().collect(Collectors.toList());
    }

    @GetMapping(value="/{id}")
    public Reservation getByIdReservation(@PathVariable @Min(1) Integer id){
        return reservationService.getReservation(id);
    }

    @PostMapping(value = "/delete")
    public boolean deleteReservation(@RequestParam @Min(1) Integer id){
        return reservationService.deleteReservation(id);
    }

    @PostMapping(value = "/create")
    public boolean saveReservation(@RequestBody @Valid Reservation reservation){
        return reservationService.addReservation(reservation);
    }

    @PostMapping(value = "/update/{id}")
    public boolean updateReservation(@PathVariable @Min(1) Integer id,@RequestBody Reservation reservation){
        return reservationService.updateReservation(id,reservation);
    }
    
}
