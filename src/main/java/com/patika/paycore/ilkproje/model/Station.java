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
public class Station implements Serializable {

    @Id
    @Column(name = "station_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "station_name")
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

    @JsonIgnore
    @OneToMany(mappedBy = "station",cascade = CascadeType.MERGE)
    private List<Reservation> reservations;

    @JsonIgnore
    @OneToMany(mappedBy = "station",cascade = CascadeType.MERGE)
    private List<ReservationDetail> reservationDetails;

}