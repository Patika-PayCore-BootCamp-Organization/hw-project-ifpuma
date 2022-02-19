package com.patika.paycore.ilkproje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Car implements Serializable {

    @Id
    @Column(name="car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="car_model")
    @NotNull(message = "model name can not be null")
    private String model;

    @Column(name="car_brand")
    @NotNull(message = "brand name can not be null")
    private String brand;

    @JsonIgnore
    @OneToMany(mappedBy = "car",cascade = CascadeType.MERGE)
    private List<Client> clients;

}
