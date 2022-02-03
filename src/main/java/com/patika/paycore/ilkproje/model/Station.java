package com.patika.paycore.ilkproje.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "station")
public class Station implements Serializable {

    @Id
    @Column(name="station_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="station_name")
    @NotNull(message = "station name can not be null")
    private String name;

    @Column(name = "station_city")
    @NotNull(message = "station name can not be null")
    private String city;

    @Column(name = "station_province")
    @NotNull(message = "station name can not be null")
    private String province;

    @Column(name = "station_address")
    @NotNull(message = "station name can not be null")
    private String address;

}
