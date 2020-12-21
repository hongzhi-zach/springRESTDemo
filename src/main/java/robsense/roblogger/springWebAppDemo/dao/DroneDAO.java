package robsense.roblogger.springWebAppDemo.dao;

import robsense.roblogger.springWebAppDemo.model.Drone;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DroneDAO {

    int postDrone(Drone drone, UUID uuid);
    default  int postDrone(Drone drone){
        UUID id = UUID.randomUUID();
        return postDrone(drone, id);
    }
    List<Drone> selectAllDrones();
    Optional<Drone> selectDroneById(UUID id);
    int deleteDroneById(UUID id);
    int updateDroneById(Drone drone, UUID id);
}
//test