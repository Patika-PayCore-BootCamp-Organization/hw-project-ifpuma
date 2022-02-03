package com.patika.paycore.ilkproje.controller;

import com.patika.paycore.ilkproje.model.Request;
import com.patika.paycore.ilkproje.service.iml.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/request")
public class RequestController {
    private final RequestService requestService;

    @GetMapping(value = "/all")
    public List<Request> getAll(){
        List<Request> allRequests = requestService.getAllRequests();
        return allRequests.stream().collect(Collectors.toList());
    }

    @GetMapping(value="/{id}")
    public Optional<Request> getByIdRequest(@PathVariable @Min(1) Integer id){
        return requestService.getRequest(id);
    }

    @PostMapping(value = "/delete")
    public boolean deleteRequest(@RequestParam @Min(1) Integer id){
        return requestService.deleteRequest(id);
    }

    @PostMapping(value = "/create")
    public boolean saveRequest(@RequestBody @Valid Request request){
        return requestService.addRequest(request);
    }

    @PostMapping(value = "/update/{id}")
    public boolean updateRequest(@PathVariable @Min(1) Integer id,@RequestBody Request request){
        return requestService.updateRequest(id,request);
    }
}
