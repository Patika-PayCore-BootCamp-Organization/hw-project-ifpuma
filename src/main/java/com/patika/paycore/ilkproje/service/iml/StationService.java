package com.patika.paycore.ilkproje.service.iml;

import com.patika.paycore.ilkproje.exception.DataIntegrityViolationException;
import com.patika.paycore.ilkproje.exception.NotFoundException;
import com.patika.paycore.ilkproje.model.Car;
import com.patika.paycore.ilkproje.model.Reservation;
import com.patika.paycore.ilkproje.model.Station;
import com.patika.paycore.ilkproje.repository.StationDal;
import com.patika.paycore.ilkproje.service.IStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StationService implements IStationService {

    @Autowired
    private StationDal stationDal;

    private final ReservationService reservationService;

    @Override
    public List<Station> getAllStations() {
        return stationDal.findAll();
    }

    @Override
    public Station getStation(Integer id) {
        Optional<Station> byId = stationDal.findById(id);
        return byId.orElseThrow(()-> new NotFoundException("Station"));
    }


    @Override
    public Station findStationByProvince(String province) {
        Station station = getAllStations().stream().filter(s->s.getProvince().equals(province)).findFirst().orElseThrow(()->new NotFoundException(province));
        return station;
    }


    @Override
    public boolean addStation(Station station) {
         stationDal.save(station);
         return true;
    }

    @Override
    public boolean deleteStation(Integer id) {
        stationDal.findById(id).orElseThrow(()-> new NotFoundException("Station"));
        Station station = stationDal.getById(id);
        try {
            Boolean isStationUsed = station.getReservations().stream().anyMatch(c ->
                    station.getReservations().equals(c)) || station.getReservationDetails().stream().anyMatch(c ->
                    station.getReservationDetails().equals(c));
            if (!isStationUsed)
                stationDal.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new DataIntegrityViolationException(station.getId());
        }
    }

    @Override
    public boolean updateStation(Integer id, Station station) {
        station.setId(id);
        stationDal.save(station);
        return true;
    }
}
