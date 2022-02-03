package com.patika.paycore.ilkproje.controller;

import com.patika.paycore.ilkproje.model.ReservationDetail;
import com.patika.paycore.ilkproje.service.iml.ReservationDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservationDetail")
public class ReservationDetailController {
    private final ReservationDetailService reservationDetailService;

    @GetMapping(value = "/all")
    public List<ReservationDetail> getAll(){
        List<ReservationDetail> allReservationDetails = reservationDetailService.getAllReservationDetails();
        return allReservationDetails.stream().collect(Collectors.toList());
    }

    @GetMapping(value="/{id}")
    public Optional<ReservationDetail> getByIdReservationDetail(@PathVariable @Min(1) Integer id){
        return reservationDetailService.getReservationDetail(id);
    }

    @PostMapping(value = "/delete")
    public boolean deleteReservationDetail(@RequestParam @Min(1) Integer id){
        return reservationDetailService.deleteReservationDetail(id);
    }

    @PostMapping(value = "/create")
    public boolean saveReservationDetail(@RequestBody @Valid ReservationDetail reservationDetail){
        return reservationDetailService.addReservationDetail(reservationDetail);
    }

    @PostMapping(value = "/update/{id}")
    public boolean updateReservationDetail(@PathVariable @Min(1) Integer id,@RequestBody ReservationDetail reservationDetail){
        return reservationDetailService.updateReservationDetail(id,reservationDetail);
    }
}
