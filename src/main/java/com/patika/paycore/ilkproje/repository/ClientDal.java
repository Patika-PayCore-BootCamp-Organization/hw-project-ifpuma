package com.patika.paycore.ilkproje.repository;

import com.patika.paycore.ilkproje.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDal extends JpaRepository<Client,Integer> {
}
