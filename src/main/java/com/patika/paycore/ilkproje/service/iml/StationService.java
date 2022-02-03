package com.patika.paycore.ilkproje.service.iml;

import com.patika.paycore.ilkproje.model.Station;
import com.patika.paycore.ilkproje.repository.StationDal;
import com.patika.paycore.ilkproje.service.IStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StationService implements IStationService {

    private final StationDal stationDal;
    @Override
    public List<Station> getAllStations() {
        return stationDal.findAll();
    }

    @Override
    public Optional<Station> getStation(Integer id) {
        return stationDal.findById(id);
    }

    @Override
    public boolean addStation(Station station) {
         stationDal.save(station);
         return true;
    }

    @Override
    public boolean deleteStation(Integer id) {
        stationDal.deleteById(id);
        return true;
    }

    @Override
    public boolean updateStation(Integer id, Station station) {
        station.setId(id);
        stationDal.save(station);
        return true;
    }
}
