package com.patika.paycore.ilkproje.repository;

import com.patika.paycore.ilkproje.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestDal extends JpaRepository<Request,Integer> {
}
