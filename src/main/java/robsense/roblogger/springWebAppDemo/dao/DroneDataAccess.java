package robsense.roblogger.springWebAppDemo.dao;

import org.springframework.stereotype.Repository;
import robsense.roblogger.springWebAppDemo.model.Drone;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresDB")
public class DroneDataAccess implements DroneDAO{

    @Override
    public int postDrone(Drone drone, UUID uuid) {
        return 0;
    }

    @Override
    public List<Drone> selectAllDrones() {
        return List.of(new Drone( "FROM POSTGRES DB", UUID.randomUUID()));
    }

    @Override
    public Optional<Drone> selectDroneById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteDroneById(UUID id) {
        return 0;
    }

    @Override
    public int updateDroneById(Drone drone, UUID id) {
        return 0;
    }
}
