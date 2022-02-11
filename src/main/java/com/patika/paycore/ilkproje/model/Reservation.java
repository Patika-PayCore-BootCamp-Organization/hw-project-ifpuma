package com.patika.paycore.ilkproje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    @NotNull(message = "station can not be null")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="station_id", referencedColumnName = "station_id")
    private Station station;

    @NotNull(message = "client can not be null")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="client_id", referencedColumnName = "client_id")
    private Client client;

}
