package com.patika.paycore.ilkproje.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Client implements Serializable {

    @Id
    @Column(name="client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="client_firstname")
    @NotNull(message = "firstname can not be null")
    private String firstname;

    @Column(name="client_lastname")
    @NotNull(message = "lastname can not be null")
    private String lastname;

    @Column(name="client_gender")
    private String gender;

    @Column(name="client_age")
    private int age;

    @Column(name="client_phone")
    private String phone;

    @Column(name="client_email")
    @NotNull(message = "email can not be null")
    private String email;

    @NotNull(message = "car can not be null")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="client_car_id", referencedColumnName = "car_id")
    private Car car;
}
