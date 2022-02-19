package com.patika.paycore.ilkproje.service;
import com.patika.paycore.ilkproje.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStationService {

    List<Station> getAllStations();

    Station getStation(Integer id);

    Station findStationByProvince(String province);

    //temel metotlar şimdilik boolean dönsün.
    boolean addStation(Station station);

    boolean deleteStation(Integer id);

    boolean updateStation(Integer id,Station station); //id ile kontrol edilmeli
}
