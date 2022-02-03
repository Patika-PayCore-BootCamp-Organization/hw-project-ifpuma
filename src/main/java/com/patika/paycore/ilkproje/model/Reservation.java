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
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @Column(name="reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="reservation_date")
    @NotNull(message = "reservation date can not be null")
    private Date reservationDate;

    @JoinColumn(name="station_id", referencedColumnName = "station_id")
    private Station station;

    @JoinColumn(name="client_id", referencedColumnName = "client_id")
    private Client client;

    @JoinColumn(name="reservation_detail_id", referencedColumnName = "reservation_detail_id")
    private ReservationDetail reservationDetail;
}
