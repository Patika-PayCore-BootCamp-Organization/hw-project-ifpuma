package com.patika.paycore.ilkproje.service;

import com.patika.paycore.ilkproje.model.Request;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IRequestService {

    List<Request> getAllRequests();

    Optional<Request> getRequest(Integer id);

    boolean addRequest(Request request);

    boolean updateRequest(Integer id,Request request);

    boolean deleteRequest(Integer id);


}
