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
public class Request implements Serializable {

    @Id
    @Column(name="request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="request_city")
    @NotNull(message = "city can not be null")
    private String city;

    @Column(name="request_province")
    @NotNull(message = "province can not be null")
    private String province;

    @Column(name="request_neighborhood")
    @NotNull(message = "neighborhood can not be null")
    private String neighborhood;

    @NotNull(message = "client can not be null")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="request_client_id", referencedColumnName = "client_id")
    private Client client;
}
