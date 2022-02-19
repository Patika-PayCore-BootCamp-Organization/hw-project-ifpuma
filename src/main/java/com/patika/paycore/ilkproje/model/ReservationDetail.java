package com.patika.paycore.ilkproje.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ReservationDetail implements Serializable {

    @Id
    @Column(name="reservation_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="station_reservation_date")
    @NotNull(message = "reservation date can not be null")
    private Date reservationDate;

    @NotNull(message = "station date can not be null")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="station_id", referencedColumnName = "station_id")
    private Station station;


}
