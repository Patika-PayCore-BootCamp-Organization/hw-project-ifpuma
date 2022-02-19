package com.patika.paycore.ilkproje.service.iml;

import com.patika.paycore.ilkproje.model.Request;
import com.patika.paycore.ilkproje.repository.RequestDal;
import com.patika.paycore.ilkproje.service.IRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestService implements IRequestService {

    private final RequestDal requestDal;

    @Override
    public List<Request> getAllRequests() {
        return requestDal.findAll();
    }

    @Override
    public Optional<Request> getRequest(Integer id) {
        return requestDal.findById(id);
    }

    @Override
    public boolean addRequest(Request request) {
        requestDal.save(request);
        return true;
    }

    @Override
    public boolean updateRequest(Integer id, Request request) {
        request.setId(id);
        requestDal.save(request);
        return true;
    }

    @Override
    public boolean deleteRequest(Integer id) {
        requestDal.deleteById(id);
        return true;
    }

}
